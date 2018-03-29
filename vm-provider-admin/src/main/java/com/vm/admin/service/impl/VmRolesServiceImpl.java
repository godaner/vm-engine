package com.vm.admin.service.impl;

import com.google.common.collect.ImmutableMap;
import com.vm.admin.dao.mapper.*;
import com.vm.admin.dao.mapper.custom.*;
import com.vm.admin.dao.po.VmRoles;
import com.vm.admin.dao.po.VmRolesAuthsRealation;
import com.vm.admin.dao.po.VmRolesMenusRealation;
import com.vm.admin.dao.qo.VmRolesQueryBean;
import com.vm.admin.service.dto.VmMenusDto;
import com.vm.admin.service.dto.VmRolesDto;
import com.vm.admin.service.exception.VmAdminException;
import com.vm.admin.service.exception.VmRolesException;
import com.vm.admin.service.inf.VmAuthsService;
import com.vm.admin.service.inf.VmMenusService;
import com.vm.admin.service.inf.VmRolesService;
import com.vm.base.util.AuthCacheManager;
import com.vm.base.util.BaseService;
import com.vm.base.util.MenuCacheManager;
import com.vm.base.util.SessionCacheManager;
import com.vm.dao.util.BasePo;
import com.vm.dao.util.PageBean;
import com.vm.dao.util.QuickSelectOne;
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
public class VmRolesServiceImpl extends BaseService implements VmRolesService {
    @Autowired
    VmAdminsMapper vmAdminsMapper;
    @Autowired
    CustomVmAdminsMapper customVmAdminsMapper;
    @Autowired
    VmAdminsLoginLogsMapper vmAdminsLoginLogsMapper;
    @Autowired
    VmMenusMapper vmMenusMapper;
    @Autowired
    CustomVmRolesMenusRealationMapper customVmRolesMenusRealationMapper;
    @Autowired
    VmAuthsMapper vmAuthsMapper;
    @Autowired
    CustomVmRolesAuthsRealationMapper customVmRolesAuthsRealationMapper;
    @Autowired
    VmRolesAuthsRealationMapper vmRolesAuthsRealationMapper;
    @Autowired
    VmAdminsRolesRealationMapper vmAdminsRolesRealationMapper;
    @Autowired
    CustomVmRolesMapper customVmRolesMapper;
    @Autowired
    CustomVmMenusMapper customVmAuthMenusMapper;
    @Autowired
    CustomVmAuthsMapper customVmAuthsMapper;
    @Autowired
    VmRolesMapper vmRolesMapper;
    @Autowired
    CustomVmAdminsRolesRealationMapper customVmAdminsRolesRealationMapper;
    @Autowired
    VmRolesMenusRealationMapper vmRolesMenusRealationMapper;
    @Autowired
    CustomVmMenusMapper customVmMenusMapper;


    //service
    @Autowired
    VmAuthsService vmAuthsService;
    @Autowired
    VmMenusService vmMenusService;

    @Override
    public List<VmRolesDto> getRoles(PageBean page, VmRolesQueryBean query) {
        List<VmRoles> vmRoles = customVmRolesMapper.getRoles(page, query);
        return makeRolesDtos(vmRoles);
    }

    @Override
    public Long getRolesTotal(PageBean page, VmRolesQueryBean query) {
        return customVmRolesMapper.getRolesTotal(page, query);
    }

    @Override
    @Transactional
    public VmRolesDto addRole(VmRolesDto vmRolesDto) {

        VmRoles vmRoles = vmRolesMapper.selectOneBy(ImmutableMap.of(
                "roleName", vmRolesDto.getRoleName(),
                "isDeleted", BasePo.IsDeleted.NO.getCode()
        ));

        if (!isNullObject(vmRoles)) {
            throw new VmRolesException("addRole role name is exits !! vmRolesDto is :" + vmRolesDto,
                    VmRolesException.ErrorCode.ROLE_NAME_IS_EXITS.getCode(),
                    VmRolesException.ErrorCode.ROLE_NAME_IS_EXITS.getMsg());
        }


        vmRoles = makeAddRole(vmRolesDto);

        if (1 != vmRolesMapper.insert(vmRoles)) {
            throw new VmRolesException("addRole vmRolesMapper#insert is fail !! vmRolesDto is :" + vmRolesDto);
        }

        //get new obj
        vmRoles = this.getRoleById(vmRoles.getId(), BasePo.IsDeleted.NO);
        Long roleId = vmRoles.getId();
        //insert role auths realations,authIds

        String authIdsStr = vmRolesDto.getAuthIds();
        if (!isEmptyString(authIdsStr)) {
            List<Long> authIds = parseStringArray2Long(authIdsStr);
            List<VmRolesAuthsRealation> newRealations = makeVmRolesAuthsRealations(roleId, authIds);

            if (newRealations.size() != vmRolesAuthsRealationMapper.batchInsert(newRealations)) {
                throw new VmRolesException("addRole vmRolesAuthsRealationMapper#batchInsert is fail ! vmRolesDto is : " + vmRolesDto);
            }
        }
        //insert role menu realations,menuIds
        String menuIdsStr = vmRolesDto.getMenuIds();
        if (!isEmptyString(menuIdsStr)) {
            List<Long> menuIds = parseStringArray2Long(menuIdsStr);

            //find parent menu
            List<Long> parentMenuIds = customVmMenusMapper.getMenuParentIdsByMenuIds(ImmutableMap.of(
                    "isDeleted", BasePo.IsDeleted.NO.getCode(),
                    "menuIds", menuIds
            ));
            menuIds.addAll(parentMenuIds);

            //insert
            List<VmRolesMenusRealation> newRealations = makeVmRolesMenusRealations(roleId, menuIds);

            if (newRealations.size() != vmRolesMenusRealationMapper.batchInsert(newRealations)) {
                throw new VmRolesException("addRole vmRolesMenusRealationMapper#batchInsert is fail ! vmRolesDto is : " + vmRolesDto);
            }
        }

        return makeRolesDto(vmRoles);
    }

    @Override
    @Transactional
    public VmRolesDto editRole(VmRolesDto vmRolesDto) {
        Long roleId = vmRolesDto.getId();

        VmRoles vmRoles = this.getRoleById(roleId, BasePo.IsDeleted.NO);


        if (!vmRoles.getRoleName().equals(vmRolesDto.getRoleName())) {//if change username
            vmRoles = vmRolesMapper.selectOneBy(ImmutableMap.of(
                    "roleName", vmRolesDto.getRoleName(),
                    "isDeleted", BasePo.IsDeleted.NO.getCode()
            ));
            if (!isNullObject(vmRoles)) {
                throw new VmRolesException("editRole role name is exits !! vmRolesDto is :" + vmRolesDto,
                        VmRolesException.ErrorCode.ROLE_NAME_IS_EXITS.getCode(),
                        VmRolesException.ErrorCode.ROLE_NAME_IS_EXITS.getMsg());
            }
        }

        //delete auths realation

        List<Long> realationIds = vmRolesAuthsRealationMapper.selectIdList(ImmutableMap.of(
                "isDeleted", BasePo.IsDeleted.NO.getCode(),
                "roleId", roleId
        ));

        if (!isEmptyList(realationIds)) {
            if (0 > vmRolesAuthsRealationMapper.updateInIds(realationIds, ImmutableMap.of(
                    "isDeleted", BasePo.IsDeleted.YES.getCode()
            ))) {
                throw new VmRolesException("editRole vmRolesAuthsRealationMapper#updateInIds is fail ! vmRolesDto is : " + vmRolesDto);
            }
        }
        //insert new auths,authIds
        String authIdsStr = vmRolesDto.getAuthIds();
        if (!isEmptyString(authIdsStr)) {
            List<Long> authIds = parseStringArray2Long(authIdsStr);
            List<VmRolesAuthsRealation> newRealations = makeVmRolesAuthsRealations(roleId, authIds);

            if (newRealations.size() != vmRolesAuthsRealationMapper.batchInsert(newRealations)) {
                throw new VmRolesException("editRole vmRolesAuthsRealationMapper#batchInsert is fail ! vmRolesDto is : " + vmRolesDto);
            }
        }

        //delete menu realation

        realationIds = vmRolesMenusRealationMapper.selectIdList(ImmutableMap.of(
                "isDeleted", BasePo.IsDeleted.NO.getCode(),
                "roleId", roleId
        ));

        if (!isEmptyList(realationIds)) {
            if (0 > vmRolesMenusRealationMapper.updateInIds(realationIds, ImmutableMap.of(
                    "isDeleted", BasePo.IsDeleted.YES.getCode()
            ))) {
                throw new VmRolesException("editRole vmRolesMenusRealationMapper#updateInIds is fail ! vmRolesDto is : " + vmRolesDto);
            }
        }
        //insert new menu,menuIds
        String menuIdsStr = vmRolesDto.getMenuIds();
        if (!isEmptyString(menuIdsStr)) {
            List<Long> menuIds = parseStringArray2Long(menuIdsStr);

            //find parent menu
            List<Long> parentMenuIds = customVmMenusMapper.getMenuParentIdsByMenuIds(ImmutableMap.of(
                    "isDeleted", BasePo.IsDeleted.NO.getCode(),
                    "menuIds", menuIds
            ));
            menuIds.addAll(parentMenuIds);

            //insert
            List<VmRolesMenusRealation> newRealations = makeVmRolesMenusRealations(roleId, menuIds);

            if (newRealations.size() != vmRolesMenusRealationMapper.batchInsert(newRealations)) {
                throw new VmRolesException("editRole vmRolesMenusRealationMapper#batchInsert is fail ! vmRolesDto is : " + vmRolesDto);
            }
        }
        //update role
        vmRoles = makeEditRole(vmRolesDto);

        if (1 != vmRolesMapper.update(roleId, vmRoles)) {
            throw new VmRolesException("editRole vmRolesMapper#update is fail !! vmRolesDto is :" + vmRolesDto);
        }

        //get new obj
        vmRoles = this.getRoleById(roleId, BasePo.IsDeleted.NO);


        //update auth and menu cache
        //if admin online ,update admin auth codes and menu tree in cache


        //get affected admin ids
        List<Long> adminIds = customVmAdminsRolesRealationMapper.getAdminIdsByRoleIds(ImmutableMap.of(
                "isDeleted", BasePo.IsDeleted.NO.getCode(),
                "roleIds", Lists.newArrayList(roleId)
        ));

        //update auth and menu cache
        this.refreshOnlineAdminAuthsAndMenus(adminIds);

        return makeRolesDto(vmRoles);
    }


    @Override
    public List<VmRolesDto> getAllRoles() {
        List<VmRoles> vmRoles = vmRolesMapper.selectBy(null);
        return makeRolesDtos(vmRoles);
    }

    @Override
    public List<Long> getRoleIdsByAdminId(Long adminId) {
        return customVmAdminsRolesRealationMapper.getRoleIdsByAdminId(ImmutableMap.of(
                "adminId", adminId,
                "isDeleted", BasePo.IsDeleted.NO.getCode()
        ));
    }

    @Override
    @Transactional
    public void deleteRole(VmRolesDto vmRolesDto) {
        int cnt = 0;
        String deletedIdsStr = vmRolesDto.getDeletedIds();
        if (isEmptyString(deletedIdsStr)) {
            throw new VmAdminException("deleteRole deleteIdsStr is empty ! deleteIdsStr is : " + deletedIdsStr);
        }
        List<Long> deletedIds = parseStringArray2Long(deletedIdsStr);

        if (isEmptyList(deletedIds)) {
            return;
        }
        //delete role menu realations
        List<Long> realationIds = customVmRolesMenusRealationMapper.getMenuIdsByRoleIds(ImmutableMap.of(
                "isDeleted", BasePo.IsDeleted.NO.getCode(),
                "roleIds", deletedIds
        ));
        if (!isEmptyList(realationIds)) {
            cnt = vmRolesMenusRealationMapper.updateInIds(realationIds, ImmutableMap.of(

                    "isDeleted", BasePo.IsDeleted.YES.getCode()
            ));
            if (0 > cnt) {
                throw new VmAdminException("deleteRole vmRolesMenusRealationMapper#updateInIds is fail ! deletedIds is : " + deletedIds);
            }
        }


        //delete role auth realations
        realationIds = customVmRolesAuthsRealationMapper.getAuthIdsByRoleIds(ImmutableMap.of(
                "isDeleted", BasePo.IsDeleted.NO.getCode(),
                "roleIds", deletedIds
        ));
        if (!isEmptyList(realationIds)) {
            cnt = vmRolesAuthsRealationMapper.updateInIds(realationIds, ImmutableMap.of(

                    "isDeleted", BasePo.IsDeleted.YES.getCode()
            ));
            if (0 > cnt) {
                throw new VmAdminException("deleteRole vmRolesAuthsRealationMapper#updateInIds is fail ! deletedIds is : " + deletedIds);
            }
        }


        //get affected admin ids
        List<Long> adminIds = customVmAdminsRolesRealationMapper.getAdminIdsByRoleIds(ImmutableMap.of(
                "isDeleted", BasePo.IsDeleted.NO.getCode(),
                "roleIds", Lists.newArrayList(deletedIds)
        ));

        //delete roles
        cnt = vmRolesMapper.updateInIds(deletedIds, ImmutableMap.of(
                "isDeleted", BasePo.IsDeleted.YES.getCode()
        ));
        if (deletedIds.size() != cnt) {
            throw new VmAdminException("deleteRole vmRolesMapper#updateInIds is fail ! deletedIds is : " + deletedIds);
        }
        //update auth and menu cache
        this.refreshOnlineAdminAuthsAndMenus(adminIds);


    }

    private void refreshOnlineAdminAuthsAndMenus(List<Long> adminIds) {
        //if admin online ,update admin auth codes and menu tree in cache
        for (Long adminId : adminIds) {
            String accessToken = SessionCacheManager.getOnlineUserToken(adminId);
            if (!isEmptyString(accessToken)) {//online ?

                //auths
                List<String> authCodes = vmAuthsService.getUseableAuthCodesByAdminId(adminId);

                AuthCacheManager.saveAuthCodes(accessToken, authCodes);

                //menuTree
                List<VmMenusDto> menuTree = vmMenusService.getUseableMenusTreeByAdminId(adminId);

                MenuCacheManager.saveMenuTree(accessToken, menuTree);
            }
        }
    }

    private List<VmRolesMenusRealation> makeVmRolesMenusRealations(Long roleId, List<Long> menuIds) {
        return menuIds.stream().parallel().map(menuId -> {
            return makeVmRolesMenusRealation(roleId, menuId);
        }).collect(toList());
    }

    private VmRolesMenusRealation makeVmRolesMenusRealation(Long roleId, Long menuId) {
        Integer now = now();
        VmRolesMenusRealation vmRolesMenusRealation = new VmRolesMenusRealation();
        vmRolesMenusRealation.setMenuId(menuId);
        vmRolesMenusRealation.setRoleId(roleId);
        vmRolesMenusRealation.setIsDeleted(BasePo.IsDeleted.NO.getCode());
        vmRolesMenusRealation.setStatus(BasePo.Status.NORMAL.getCode());
        vmRolesMenusRealation.setCreateTime(now);
        vmRolesMenusRealation.setUpdateTime(now);
        return vmRolesMenusRealation;
    }

    private List<VmRolesAuthsRealation> makeVmRolesAuthsRealations(Long roleId, List<Long> authIds) {
        return authIds.stream().parallel().map(authId -> {
            return makeVmRolesAuthsRealation(roleId, authId);
        }).collect(toList());
    }

    private VmRolesAuthsRealation makeVmRolesAuthsRealation(Long roleId, Long authId) {
        Integer now = now();
        VmRolesAuthsRealation vmRolesAuthsRealation = new VmRolesAuthsRealation();
        vmRolesAuthsRealation.setAuthId(authId);
        vmRolesAuthsRealation.setRoleId(roleId);
        vmRolesAuthsRealation.setIsDeleted(BasePo.IsDeleted.NO.getCode());
        vmRolesAuthsRealation.setStatus(BasePo.Status.NORMAL.getCode());
        vmRolesAuthsRealation.setCreateTime(now);
        vmRolesAuthsRealation.setUpdateTime(now);
        return vmRolesAuthsRealation;
    }


    private VmRoles makeEditRole(VmRolesDto vmRolesDto) {
        Integer now = now();
        VmRoles vmRoles = new VmRoles();
        vmRoles.setDescription(vmRolesDto.getDescription());
        vmRoles.setRoleName(vmRolesDto.getRoleName());
        vmRoles.setStatus(vmRolesDto.getStatus());
        vmRoles.setUpdateTime(now);
        return vmRoles;
    }

    private VmRoles makeAddRole(VmRolesDto vmRolesDto) {
        Integer now = now();
        VmRoles vmRoles = new VmRoles();
        vmRoles.setDescription(vmRolesDto.getDescription());
        vmRoles.setImmutable(BasePo.Immutable.NO.getCode());
        vmRoles.setRoleName(vmRolesDto.getRoleName());
        vmRoles.setStatus(vmRolesDto.getStatus());
        vmRoles.setIsDeleted(BasePo.IsDeleted.NO.getCode());
        vmRoles.setCreateTime(now);
        vmRoles.setUpdateTime(now);
        return vmRoles;
    }

    private List<VmRolesDto> makeRolesDtos(List<VmRoles> vmRoles) {
        return vmRoles.stream().parallel().map(r -> {
            return makeRolesDto(r);
        }).collect(toList());
    }

    private VmRolesDto makeRolesDto(VmRoles vmRoles) {
        VmRolesDto vmRolesDto = new VmRolesDto();
        vmRolesDto.setId(vmRoles.getId());
        vmRolesDto.setDescription(vmRoles.getDescription());
        vmRolesDto.setImmutable(vmRoles.getImmutable());
        vmRolesDto.setRoleName(vmRoles.getRoleName());
        vmRolesDto.setCreateTime(vmRoles.getCreateTime());
        vmRolesDto.setUpdateTime(vmRoles.getUpdateTime());
        vmRolesDto.setStatus(vmRoles.getStatus());
        return vmRolesDto;
    }

    private VmRoles getRoleById(Long id, BasePo.Status status, BasePo.IsDeleted isDeleted) {

        return QuickSelectOne.getObjectById(vmRolesMapper, id, status, isDeleted);
    }

    private VmRoles getRoleById(Long id, BasePo.IsDeleted isDeleted) {

        return QuickSelectOne.getObjectById(vmRolesMapper, id, isDeleted);
    }
}
