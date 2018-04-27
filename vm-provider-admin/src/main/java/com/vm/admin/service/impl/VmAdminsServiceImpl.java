package com.vm.admin.service.impl;

import com.google.common.collect.ImmutableMap;
import com.vm.admin.dao.mapper.*;
import com.vm.admin.dao.mapper.custom.*;
import com.vm.admin.dao.po.VmAdmins;
import com.vm.admin.dao.po.VmAdminsLoginLogs;
import com.vm.admin.dao.po.VmAdminsRolesRealation;
import com.vm.admin.dao.qo.VmAdminsQueryBean;
import com.vm.admin.service.dto.VmAdminsDto;
import com.vm.admin.service.dto.VmMenusDto;
import com.vm.admin.service.exception.VmAdminException;
import com.vm.admin.service.inf.VmAdminsService;
import com.vm.admin.service.inf.VmAuthsService;
import com.vm.admin.service.inf.VmMenusService;
import com.vm.auth.admin.cache.AdminSessionCacheManager;
import com.vm.auth.admin.cache.AuthCacheManager;
import com.vm.auth.admin.cache.MenuCacheManager;
import com.vm.base.util.BaseService;
import com.vm.base.util.DateUtil;
import com.vm.dao.util.BasePo;
import com.vm.dao.util.PageBean;
import com.vm.dao.util.QuickSelectOne;
import com.vm.mq.sender.AdminOnlineStatusMQSender;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Created by ZhangKe on 2018/3/26.
 */
@Service
public class VmAdminsServiceImpl extends BaseService implements VmAdminsService {
    @Autowired
    VmAdminsMapper vmAdminsMapper;
    @Autowired
    CustomVmAdminsMapper customVmAdminsMapper;
    @Autowired
    VmAdminsLoginLogsMapper vmAdminsLoginLogsMapper;
    @Autowired
    VmMenusMapper vmAuthMenusMapper;
    @Autowired
    CustomVmRolesMenusRealationMapper customVmRolesMenusRealationMapper;
    @Autowired
    VmAuthsMapper vmAuthsMapper;
    @Autowired
    CustomVmRolesAuthsRealationMapper customVmRolesAuthsRealationMapper;
    @Autowired
    VmAdminsRolesRealationMapper vmAdminsRolesRealationMapper;
    @Autowired
    CustomVmRolesMapper customVmRolesMapper;
    @Autowired
    CustomVmMenusMapper customVmAuthMenusMapper;
    @Autowired
    CustomVmAuthsMapper customVmAuthsMapper;

    @Autowired
    CustomVmAdminsRolesRealationMapper customVmAdminsRolesRealationMapper;


    //service
    @Autowired
    VmAuthsService vmAuthsService;

    @Autowired
    VmMenusService vmMenusService;

    @Override
    public List<VmAdminsDto> getAdmins(PageBean page, VmAdminsQueryBean query) {
        List<VmAdmins> admins = customVmAdminsMapper.getAdmins(page, query);

        return makeBackendAdminsDtos(admins);
    }

    private List<VmAdminsDto> makeBackendAdminsDtos(List<VmAdmins> admins) {
        return admins.stream().parallel().map(vmAdmins -> {
            return makeBackendAdminsDto(vmAdmins);
        }).collect(toList());
    }

    private VmAdminsDto makeBackendAdminsDto(VmAdmins vmAdmins) {
        VmAdminsDto vmAdminsDto = new VmAdminsDto();
        vmAdminsDto.setCreateTime(vmAdmins.getCreateTime());
        vmAdminsDto.setUpdateTime(vmAdmins.getUpdateTime());
        vmAdminsDto.setId(vmAdmins.getId());
        vmAdminsDto.setDescription(vmAdmins.getDescription());
        vmAdminsDto.setImmutable(vmAdmins.getImmutable());
        vmAdminsDto.setUsername(vmAdmins.getUsername());
        vmAdminsDto.setPassword(vmAdmins.getPassword());
        vmAdminsDto.setStatus(vmAdmins.getStatus());
        return vmAdminsDto;
    }

    @Override
    public Long getAdminsTotal(PageBean page, VmAdminsQueryBean query) {
        return customVmAdminsMapper.getAdminsTotal(page, query);
    }

    @Override
    public VmAdminsDto addAdmin(VmAdminsDto vmAdminsDto) {
        VmAdmins vmAdmins = vmAdminsMapper.selectOneBy(ImmutableMap.of(
                "isDeleted", BasePo.IsDeleted.NO.getCode(),
                "username", vmAdminsDto.getUsername()
        ));
        if (!isNullObject(vmAdmins)) {
            throw new VmAdminException("addAdmin username is exits !! vmAdminsDto is : " + vmAdminsDto,
                    VmAdminException.ErrorCode.USERNAME_IS_EXITS.getCode(),
                    VmAdminException.ErrorCode.USERNAME_IS_EXITS.getMsg());
        }

        vmAdmins = makeAddAdmin(vmAdminsDto);

        if (1 != vmAdminsMapper.insert(vmAdmins)) {
            throw new VmAdminException("addAdmin vmAdminsMapper#insert is fail !! vmAdminsDto is : " + vmAdminsDto);
        }

        vmAdmins = this.getAdminById(vmAdmins.getId(), BasePo.IsDeleted.NO);
        //insert admin role realations
        String roleIdsStr = vmAdminsDto.getRoleIds();
        if (!isEmptyString(roleIdsStr)) {
            List<Long> roleIds = parseStringArray2Long(roleIdsStr);
            List<VmAdminsRolesRealation> vmAdminsRolesRealations = makeVmAdminsRolesRealations(vmAdmins.getId(), roleIds);
            if (0 > vmAdminsRolesRealationMapper.batchInsert(vmAdminsRolesRealations)) {
                throw new VmAdminException("addAdmin vmAdminsRolesRealationMapper#batchInsert is fail !! vmAdminsDto is : " + vmAdminsDto);
            }
        }

        return makeBackendAdminsDto(vmAdmins);
    }


    @Override
    @Transactional
    public VmAdminsDto editAdmin(VmAdminsDto vmAdminsDto) {
        Long adminId = vmAdminsDto.getId();
        VmAdmins vmAdmins = this.getAdminById(adminId, BasePo.IsDeleted.NO);

        if (BasePo.Immutable.isImmutable(vmAdmins.getImmutable())) {
            throw new VmAdminException("addAdmin can not operate immutable obj !! vmAdminsDto is : " + vmAdminsDto,
                    VmAdminException.ErrorCode.CAN_NOT_OPERATE_IMMUTABLE.getCode(),
                    VmAdminException.ErrorCode.CAN_NOT_OPERATE_IMMUTABLE.getMsg());
        }

        if (!vmAdmins.getUsername().equals(vmAdminsDto.getUsername())) {
            vmAdmins = vmAdminsMapper.selectOneBy(ImmutableMap.of(
                    "isDeleted", BasePo.IsDeleted.NO.getCode(),
                    "username", vmAdminsDto.getUsername()
            ));
            if (!isNullObject(vmAdmins)) {
                throw new VmAdminException("addAdmin username is exits !! vmAdminsDto is : " + vmAdminsDto,
                        VmAdminException.ErrorCode.USERNAME_IS_EXITS.getCode(),
                        VmAdminException.ErrorCode.USERNAME_IS_EXITS.getMsg());
            }
        }

        //update obj
        vmAdmins = makeEditAdmin(vmAdminsDto);

        if (1 != vmAdminsMapper.update(adminId, vmAdmins)) {
            throw new VmAdminException("addAdmin vmAdminsMapper#update is fail !! vmAdminsDto is : " + vmAdminsDto);
        }

        vmAdmins = this.getAdminById(adminId, BasePo.IsDeleted.NO);

        //delete admin role realations
        List<Long> realationIds = vmAdminsRolesRealationMapper.selectIdList(ImmutableMap.of(
                "isDeleted", BasePo.IsDeleted.NO.getCode(),
                "adminId", adminId
        ));
        if (!isEmptyList(realationIds)) {
            if (0 > vmAdminsRolesRealationMapper.updateInIds(realationIds, ImmutableMap.of(
                    "isDeleted", BasePo.IsDeleted.YES.getCode()
            ))) {
                throw new VmAdminException("addAdmin vmAdminsRolesRealationMapper#updateInIds is fail !! vmAdminsDto is : " + vmAdminsDto);
            }
        }


        //insert admin role realations
        String roleIdsStr = vmAdminsDto.getRoleIds();
        if (!isEmptyString(roleIdsStr)) {
            List<Long> roleIds = parseStringArray2Long(roleIdsStr);
            List<VmAdminsRolesRealation> vmAdminsRolesRealations = makeVmAdminsRolesRealations(adminId, roleIds);
            if (0 > vmAdminsRolesRealationMapper.batchInsert(vmAdminsRolesRealations)) {
                throw new VmAdminException("addAdmin vmAdminsRolesRealationMapper#batchInsert is fail !! vmAdminsDto is : " + vmAdminsDto);
            }
        }

        // tail
        VmAdminsDto adminsDto = makeBackendAdminsDto(vmAdmins);
        String accessToken = AdminSessionCacheManager.getOnlineUserToken(adminId);
        if (isEmptyString(accessToken)) {//online ?
            return adminsDto;
        }
        //is frozen?
        if (VmAdmins.Status.isFrozen(vmAdmins.getStatus())) {
            AdminOnlineStatusMQSender.tipUserIsFrozened(accessToken);
            AdminSessionCacheManager.userLogout(accessToken);
            return adminsDto;
        }
        //update basic info ? tip client
        AdminOnlineStatusMQSender.tipUserInfoIsUpdated(accessToken, adminsDto);

        //update online admin's auth and menu cache
        this.refreshOnlineAdminAuthsAndMenus(Lists.newArrayList(adminId));

        return adminsDto;
    }

    @Override
    public void refreshOnlineAdminAuthsAndMenus(List<Long> adminIds) {
        //if admin online ,update admin auth codes and menu tree in cache
        adminIds.stream().parallel().forEach(adminId -> {
            String accessToken = AdminSessionCacheManager.getOnlineUserToken(adminId);
            if (!isEmptyString(accessToken)) {//online ?

                //auths
                List<String> authCodes = vmAuthsService.getUseableAuthCodesByAdminId(adminId);

                AuthCacheManager.saveAuthCodes(accessToken, authCodes);

                //menuTree
                List<VmMenusDto> menuTree = vmMenusService.getUseableMenusTreeByAdminId(adminId);

                MenuCacheManager.saveMenuTree(accessToken, menuTree);

                //tip admin
                AdminOnlineStatusMQSender.tipAdminUpdateMenu(accessToken, menuTree);
            }
        });
    }



    private List<VmAdminsRolesRealation> makeVmAdminsRolesRealations(Long adminId, List<Long> roleIds) {
        return roleIds.stream().parallel().map(roleId -> {
            return makeVmAdminsRolesRealation(adminId, roleId);
        }).collect(toList());
    }

    private VmAdminsRolesRealation makeVmAdminsRolesRealation(Long adminId, Long roleId) {
        Integer now = now();
        VmAdminsRolesRealation vmAdminsRolesRealation = new VmAdminsRolesRealation();
        vmAdminsRolesRealation.setAdminId(adminId);
        vmAdminsRolesRealation.setRoleId(roleId);
        vmAdminsRolesRealation.setIsDeleted(BasePo.IsDeleted.NO.getCode());
        vmAdminsRolesRealation.setStatus(BasePo.Status.NORMAL.getCode());
        vmAdminsRolesRealation.setCreateTime(now);
        vmAdminsRolesRealation.setUpdateTime(now);
        return vmAdminsRolesRealation;
    }

    private VmAdmins makeAddAdmin(VmAdminsDto vmAdminsDto) {
        VmAdmins vmAdmins = new VmAdmins();
        Integer now = now();
        vmAdmins.setDescription(vmAdminsDto.getDescription());
        vmAdmins.setPassword(vmAdminsDto.getPassword());
        vmAdmins.setUsername(vmAdminsDto.getUsername());
        vmAdmins.setStatus(vmAdminsDto.getStatus());
        vmAdmins.setIsDeleted(BasePo.IsDeleted.NO.getCode());
        vmAdmins.setImmutable(BasePo.Immutable.NO.getCode());
        vmAdmins.setUpdateTime(now);
        vmAdmins.setCreateTime(now);
        return vmAdmins;
    }

    private VmAdmins makeEditAdmin(VmAdminsDto vmAdminsDto) {
        VmAdmins vmAdmins = new VmAdmins();
        Integer now = now();
        vmAdmins.setDescription(vmAdminsDto.getDescription());
        vmAdmins.setPassword(vmAdminsDto.getPassword());
        vmAdmins.setUsername(vmAdminsDto.getUsername());
        vmAdmins.setStatus(vmAdminsDto.getStatus());
        vmAdmins.setCreateTime(now);
        return vmAdmins;
    }

    @Override
    public VmAdmins getAdminById(Long userId, BasePo.Status status, BasePo.IsDeleted isDeleted) {

        return QuickSelectOne.getObjectById(vmAdminsMapper, userId, status, isDeleted);
    }

    @Override
    public VmAdmins getAdminById(Long userId, BasePo.IsDeleted isDeleted) {

        return QuickSelectOne.getObjectById(vmAdminsMapper, userId, isDeleted);
    }

    @Override
    @Transactional
    public VmAdminsDto adminLogin(VmAdminsDto vmAdminsDto) throws Exception {

        //username is right?
        VmAdmins vmAdmins = vmAdminsMapper.selectOneBy(ImmutableMap.of(
                "username", vmAdminsDto.getUsername(),
                "status", BasePo.Status.NORMAL.getCode(),
                "isDeleted", BasePo.IsDeleted.NO.getCode()
        ));


        if (isNullObject(vmAdmins)) {
            throw new VmAdminException("adminLogin admin username is not exits ! admin is : " + vmAdminsDto,
                    VmAdminException.ErrorCode.USERNAME_IS_NOT_EXITS.getCode(),
                    VmAdminException.ErrorCode.USERNAME_IS_NOT_EXITS.getMsg());
        }
        //password is right?
        if (!vmAdmins.getPassword().equals(vmAdminsDto.getPassword())) {
            throw new VmAdminException("adminLogin password is error ! admin is :  " + vmAdminsDto,
                    VmAdminException.ErrorCode.PASSWORD_ERROR.getCode(),
                    VmAdminException.ErrorCode.PASSWORD_ERROR.getMsg());
        }

        Long adminId = vmAdmins.getId();
        //write adminLogin record to db
        VmAdminsLoginLogs vmAdminsLoginLogs = makeAdminLogins(vmAdminsDto, adminId);
        if (1 != vmAdminsLoginLogsMapper.insert(vmAdminsLoginLogs)) {
            throw new VmAdminException("adminLogin vmAdminsLoginLogsMapper#insert is fail ! user is :  " + vmAdminsDto);
        }


        //logout old session
        String oldToken = AdminSessionCacheManager.getOnlineUserToken(adminId);
        if (!isEmptyString(oldToken)) {
            AdminSessionCacheManager.userLogout(oldToken);
            AdminOnlineStatusMQSender.tipLogoutWhenUserLoginInOtherArea(oldToken, vmAdminsLoginLogs);//tip when login in other area
        }
        //add new session
        String token = AdminSessionCacheManager.userLogin(adminId);

        //refresh admin auth and menu
        this.initOnlineAdminAuthsAndMenus(Lists.newArrayList(adminId));


        return makeVmAdminDto(vmAdmins, token);
    }

    /**
     * init online admin auth menu cache
     * @param adminIds
     */
    private void initOnlineAdminAuthsAndMenus(List<Long> adminIds) {
        //if admin online ,update admin auth codes and menu tree in cache
        adminIds.stream().parallel().forEach(adminId -> {
            String accessToken = AdminSessionCacheManager.getOnlineUserToken(adminId);
            if (!isEmptyString(accessToken)) {//online ?

                //auths
                List<String> authCodes = vmAuthsService.getUseableAuthCodesByAdminId(adminId);

                AuthCacheManager.saveAuthCodes(accessToken, authCodes);

                //menuTree
                List<VmMenusDto> menuTree = vmMenusService.getUseableMenusTreeByAdminId(adminId);

                MenuCacheManager.saveMenuTree(accessToken, menuTree);

            }
        });
    }

    @Override
    public VmAdminsDto getOnlineAdminBasicInfo(String token) {


        if (null == token) {
            return null;
        }
        Long adminId = AdminSessionCacheManager.getOnlineUserId(token);

        if (null == adminId) {
            return null;
        }
        VmAdmins vmAdmins = this.getAdminById(adminId, BasePo.Status.NORMAL, BasePo.IsDeleted.NO);
        if (null == vmAdmins) {
            return null;
        }
        //get db use

        VmAdminsDto vmAdminsDto = makeVmAdminDto(vmAdmins, token);

        return vmAdminsDto;
    }

    @Override
    public void adminLogout(String token) {
        AdminSessionCacheManager.userLogout(token);
    }


    private VmAdminsLoginLogs makeAdminLogins(VmAdminsDto vmAdminsDto, Long adminId) {
        Integer now = DateUtil.unixTime().intValue();
        VmAdminsLoginLogs vmAdminsLoginLogs = new VmAdminsLoginLogs();
        vmAdminsLoginLogs.setBrower(vmAdminsDto.getBrowser());
        vmAdminsLoginLogs.setCity(vmAdminsDto.getCity());
        vmAdminsLoginLogs.setCountry(vmAdminsDto.getCountry());
        vmAdminsLoginLogs.setDpi(vmAdminsDto.getDpi());
        vmAdminsLoginLogs.setLoginIp(vmAdminsDto.getIp());
        vmAdminsLoginLogs.setProvince(vmAdminsDto.getProvince());
        vmAdminsLoginLogs.setSystem(vmAdminsDto.getSystem());
        vmAdminsLoginLogs.setAdminId(adminId);
        vmAdminsLoginLogs.setResult(VmAdminsLoginLogs.Result.SUCCESS.getCode());
        vmAdminsLoginLogs.setLoginTime(now);
        vmAdminsLoginLogs.setCreateTime(now);
        vmAdminsLoginLogs.setUpdateTime(now);
        vmAdminsLoginLogs.setIsDeleted(BasePo.IsDeleted.NO.getCode());
        vmAdminsLoginLogs.setStatus(BasePo.Status.NORMAL.getCode());
        return vmAdminsLoginLogs;
    }

    @Override
    public VmAdminsDto makeVmAdminDto(VmAdmins vmAdmins, String token) {
        VmAdminsDto vmAdminsDto = new VmAdminsDto();
        vmAdminsDto.setUsername(vmAdmins.getUsername());
        vmAdminsDto.setId(vmAdmins.getId());
        vmAdminsDto.setDescription(vmAdmins.getDescription());
        vmAdminsDto.setToken(token);
        return vmAdminsDto;
    }

    @Override
    @Transactional
    public void deleteAdmin(VmAdminsDto vmAdminsDto) {
        int cnt = 0;
        String deletedIdsStr = vmAdminsDto.getDeletedIds();
        if (isEmptyString(deletedIdsStr)) {
            throw new VmAdminException("deleteAdmin deleteIdsStr is empty ! deleteIdsStr is : " + deletedIdsStr);
        }
        List<Long> deletedIds = parseStringArray2Long(deletedIdsStr);

        if (isEmptyList(deletedIds)) {
            return;
        }

        //delete admin role realation
        List<Long> realationIds = customVmAdminsRolesRealationMapper.getRealationIdsByAdminIds(ImmutableMap.of(
                "isDeleted", BasePo.IsDeleted.NO.getCode(),
                "adminIds", deletedIds
        ));
        if (!isEmptyList(realationIds)) {
            cnt = vmAdminsRolesRealationMapper.updateInIds(realationIds, ImmutableMap.of(

                    "isDeleted", BasePo.IsDeleted.YES.getCode()
            ));
            if (0 > cnt) {
                throw new VmAdminException("deleteAdmin vmAdminsRolesRealationMapper#updateInIds is fail ! deletedIds is : " + deletedIds);
            }
        }


        //delete admin
        cnt = vmAdminsMapper.updateInIds(deletedIds, ImmutableMap.of(
                "isDeleted", BasePo.IsDeleted.YES.getCode()
        ));
        if (0 > cnt) {
            throw new VmAdminException("deleteAdmin vmAdminsMapper#updateInIds is fail ! deletedIds is : " + deletedIds);
        }

        //tail
        this.tipOnlineAdminsIsDeleted(deletedIds);

    }

    private void tipOnlineAdminsIsDeleted(List<Long> adminIds) {
        adminIds.stream().parallel().forEach(adminId -> {
            String accessToken = AdminSessionCacheManager.getOnlineUserToken(adminId);
            if (!isEmptyString(accessToken)) {//online ?
                AdminOnlineStatusMQSender.tipUserIsDeleted(accessToken);
                AdminSessionCacheManager.userLogout(accessToken);
            }
        });
    }
}
