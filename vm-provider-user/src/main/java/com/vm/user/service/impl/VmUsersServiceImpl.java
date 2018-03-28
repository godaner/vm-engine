package com.vm.user.service.impl;

import com.google.common.collect.ImmutableMap;
import com.vm.base.service.dto.UpdateHeadImgInfo;
import com.vm.base.util.*;
import com.vm.dao.util.BasePo;
import com.vm.dao.util.PageBean;
import com.vm.dao.util.QuickSelectOne;
import com.vm.user.config.UserConfig;
import com.vm.user.dao.mapper.VmUsersLoginLogsMapper;
import com.vm.user.dao.mapper.VmUsersMapper;
import com.vm.user.dao.mapper.custom.CustomVmUsersMapper;
import com.vm.user.dao.po.VmUsers;
import com.vm.user.dao.po.VmUsersLoginLogs;
import com.vm.user.dao.qo.VmUserQueryBean;
import com.vm.user.feign.service.SrcServiceClient;
import com.vm.user.service.dto.VmUsersDto;
import com.vm.user.service.exception.VmUsersException;
import com.vm.user.service.inf.VmUsersService;
import com.vm.base.util.SessionCacheManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Created by ZhangKe on 2017/12/28.
 */
@Service
public class VmUsersServiceImpl extends BaseService implements VmUsersService {
    @Autowired
    private VmUsersMapper vmUsersMapper;
    @Autowired
    private VmUsersLoginLogsMapper vmUsersLoginLogsMapper;
    @Autowired
    private CustomVmUsersMapper customVmUsersMapper;

    @Autowired
    private SrcServiceClient srcServiceClient;
    @Autowired
    private UserConfig userConfig;

    private VmUsersDto makeVmUsersDto(VmUsers user, String token) {
        VmUsersDto vmUsersDto = new VmUsersDto();
        vmUsersDto.setUsername(user.getUsername());
        vmUsersDto.setId(user.getId());
        vmUsersDto.setBirthday(user.getBirthday());
        vmUsersDto.setDescription(user.getDescription());
        vmUsersDto.setSex(user.getSex());
        vmUsersDto.setImgUrl(user.getImgUrl());
        vmUsersDto.setToken(token);
        return vmUsersDto;
    }

    private VmUsersDto makeVmUsersDto(VmUsers user) {
        VmUsersDto vmUsersDto = new VmUsersDto();
        vmUsersDto.setUsername(user.getUsername());
        vmUsersDto.setId(user.getId());
        vmUsersDto.setBirthday(user.getBirthday());
        vmUsersDto.setDescription(user.getDescription());
        vmUsersDto.setSex(user.getSex());
        vmUsersDto.setImgUrl(user.getImgUrl());
        return vmUsersDto;
    }

    @Override
    @Transactional
    public VmUsersDto userLogin(VmUsersDto vmUsersDto) throws Exception {

        //username is right?
        VmUsers dbUser = this.getUserByUsername(vmUsersDto.getUsername(), BasePo.Status.NORMAL, BasePo.IsDeleted.NO);

        if (isNullObject(dbUser)) {
            throw new VmUsersException("userLogin dbUser is not exits ! user is : " + vmUsersDto,
                    VmUsersException.ErrorCode.USER_IS_NOT_EXITS.getCode(), VmUsersException.ErrorCode.USER_IS_NOT_EXITS.getMsg());
        }
        //password is right?
        if (!dbUser.getPassword().equals(vmUsersDto.getPassword())) {
            throw new VmUsersException("userLogin password is error ! user is :  " + vmUsersDto,
                    VmUsersException.ErrorCode.PASSWORD_ERROR.getCode(), VmUsersException.ErrorCode.USER_IS_NOT_EXITS.getMsg());
        }

        //write login record to db
        if (1 != vmUsersLoginLogsMapper.insert(makeUserLogins(vmUsersDto, dbUser.getId()))) {
            throw new VmUsersException("userLogin vmUsersLoginLogsMapper#insert is fail ! user is :  " + vmUsersDto);
        }

        //login in session
        String token = SessionCacheManager.userLogin(dbUser.getId());

        return makeVmUsersDto(dbUser, token);
    }

    private VmUsersLoginLogs makeUserLogins(VmUsersDto vmUsersDto, Long userId) {
        Integer now = DateUtil.unixTime().intValue();
        VmUsersLoginLogs vmUsersLoginLogs = new VmUsersLoginLogs();
        vmUsersLoginLogs.setBrower(vmUsersDto.getBrowser());
        vmUsersLoginLogs.setCity(vmUsersDto.getCity());
        vmUsersLoginLogs.setCountry(vmUsersDto.getCountry());
        vmUsersLoginLogs.setDpi(vmUsersDto.getDpi());
        vmUsersLoginLogs.setLoginIp(vmUsersDto.getIp());
        vmUsersLoginLogs.setProvince(vmUsersDto.getProvince());
        vmUsersLoginLogs.setSystem(vmUsersDto.getSystem());
        vmUsersLoginLogs.setUserId(userId);
        vmUsersLoginLogs.setResult(VmUsersLoginLogs.Result.SUCCESS.getCode());
        vmUsersLoginLogs.setLoginTime(now);
        vmUsersLoginLogs.setCreateTime(now);
        vmUsersLoginLogs.setUpdateTime(now);
        vmUsersLoginLogs.setIsDeleted(BasePo.IsDeleted.NO.getCode());
        vmUsersLoginLogs.setStatus(BasePo.Status.NORMAL.getCode());
        return vmUsersLoginLogs;
    }

    @Override
    public VmUsersDto getUserBasicInfo(Long userId) {

        //获取指定id的user
        VmUsers dbUser = this.getUsableUserById(userId, BasePo.Status.NORMAL, BasePo.IsDeleted.NO);

        if (isNullObject(dbUser) || VmUsers.IsDeleted.isDeleted(dbUser.getIsDeleted())) {
            throw new VmUsersException("getUserBasicInfo user is not exits! userId is : " + userId,
                    VmUsersException.ErrorCode.USER_IS_NOT_EXITS.getCode(), VmUsersException.ErrorCode.USER_IS_NOT_EXITS.getMsg());
        }


        return makeVmUsersDto(dbUser);
    }


    @Override
    @Transactional
    public VmUsersDto updateOnlineUserBasicInfo(VmUsersDto user) throws Exception {
        //user是否存在
        VmUsers dbUser = this.getUsableUserById(user.getId(), BasePo.Status.NORMAL, BasePo.IsDeleted.NO);

        if (isNullObject(dbUser) || VmUsers.IsDeleted.isDeleted(dbUser.getIsDeleted())) {
            throw new VmUsersException("updateOnlineUserBasicInfo dbUser is not exits ! user is : " + user,
                    VmUsersException.ErrorCode.USER_IS_NOT_EXITS.getCode(), VmUsersException.ErrorCode.USER_IS_NOT_EXITS.getMsg());
        }


        vmUsersMapper.update(user.getId(), makeUpdateOnlineVmUsers(user));

        return makeVmUsersDto(vmUsersMapper.select(user.getId()));
    }

    /**
     * 构建VmUsers
     *
     * @param user
     * @return
     */
    private VmUsers makeUpdateOnlineVmUsers(VmUsersDto user) {
        VmUsers vmUser = new VmUsers();
        vmUser.setId(user.getId());
        vmUser.setBirthday(user.getBirthday());
        vmUser.setUpdateTime(DateUtil.unixTime().intValue());
        vmUser.setDescription(user.getDescription());
        vmUser.setSex(user.getSex());
        return vmUser;
    }

    @Override
    public void sendUserImg(Long fileId, Integer width, HttpServletResponse response) throws Exception {

//        if (isNullObject(width)) {
//            throw new VmUsersException("sendUserImg width is null ! fileId is : " + fileId + " , width is : " + width,
//                    VmUsersException.ErrorCode.USER_HEAD_IMG_WIDTH_IS_NULL.getCode(),
//                    VmUsersException.ErrorCode.USER_HEAD_IMG_WIDTH_IS_NULL.getMsg());
//        }
//        FileInputStream input = null;
//        ServletOutputStream output = null;
//        try {
//            //获取用户图片id信息
//            VmFiles file = vmFilesMapper.select(fileId);
////            String userImgPath = ServerConfig.VM_USER_IMG_PATH;
//            String userImgName = null;
//            String contentType = null;
//            if (file != null) {
//                contentType = file.getContentType();
//                userImgName = file.getFilename();
//            }
//            if (width == null) {
//                width = 300;
//            }
//            File f = new File(userImgPath + File.separator + width + "_" + userImgName);
//            //不存在，返回默认图片
//            if (!f.exists()) {
//                f = new File(userImgPath + File.separator + ServerConfig.VM_USER_IMG_DEFAULT_NAME);
//            }
//            output = response.getOutputStream();
//            input = new FileInputStream(f);
//            //设置响应的媒体类型
//
//            response.setContentType(contentType); // 设置返回的文件类型
//            IOUtils.copy(input, output);
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            closeStream(input, output);
//        }
    }

    @Override
    @Transactional
    public VmUsersDto userRegist(VmUsersDto user) throws Exception {

        //是否存在username相同的账户
        if (!isNullObject(this.getUserByUsername(user.getUsername(), BasePo.Status.NORMAL, BasePo.IsDeleted.NO))) {

            throw new VmUsersException("userRegist username is exits ! user is :  " + user,
                    VmUsersException.ErrorCode.USER_IS_NOT_EXITS.getCode(), VmUsersException.ErrorCode.USER_IS_NOT_EXITS.getMsg());
        }

        vmUsersMapper.insert(makeRegistVmUserPo(user));

        VmUsers vmUsers = getUserByUsername(user.getUsername(), BasePo.Status.NORMAL, BasePo.IsDeleted.NO);


        //login in session
        String token = SessionCacheManager.userLogin(vmUsers.getId());

        return makeVmUsersDto(vmUsers, token);
    }


    @Override
    public void getUserTempHeadImg(Long fileId, HttpServletResponse response) throws Exception {
//        InputStream inputStream = null;
//        OutputStream outputStream = null;
//        try {
//
//            VmFiles vmFiles = vmFilesMapper.select(fileId);
//            String targetPath = ServerConfig.VM_USER_IMG_TEMP_PATH;
//            String targetHeadImgPathName = targetPath + File.separator + vmFiles.getFilename();
//            inputStream = new FileInputStream(targetHeadImgPathName);
//            org.apache.commons.io.IOUtils.copy(inputStream, response.getOutputStream());
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            closeStream(inputStream, outputStream);
//        }

    }

    @Override
    @Transactional
    public VmUsersDto updateUserHeadImg(Long onlineUserId, UpdateHeadImgInfo updateHeadImgInfo) throws Exception {
        //set versions
        updateHeadImgInfo.setVersions(userConfig.getUserImgVersions());

        //feign
        String res = srcServiceClient.cutUploadedImgFile(BeanMapUtil.beanToMap(updateHeadImgInfo));
        Response response = Response.parseJSON(res);
        if (response.isFailure()) {
            throw new VmUsersException("updateUserHeadImg srcServiceClient#cutUploadedImgFile is fail !! onlineUserId is :" + onlineUserId + " , updateHeadImgInfo is : " + updateHeadImgInfo);
        }
        String imgUrl = (String) response.getData("imgUrl");
        //update user
        VmUsers vmUsers = new VmUsers();
        vmUsers.setId(onlineUserId);
        vmUsers.setImgUrl(imgUrl);
        vmUsersMapper.update(vmUsers.getId(), vmUsers);


        //get new user
        vmUsers = this.getUsableUserById(vmUsers.getId(), BasePo.Status.NORMAL, BasePo.IsDeleted.NO);

        return vmUsers == null ? null : makeVmUsersDto(vmUsers);

    }


    /**
     * 通过username获取user
     *
     * @param username
     * @return
     */
    private VmUsers getUserByUsername(String username, BasePo.IsDeleted isDeleted) {
        //是否存在此username的user
        return vmUsersMapper.selectOneBy(ImmutableMap.of(
                "username", username,
                "isDeleted", isDeleted.getCode()
        ));
    }

    /**
     * 通过username获取user
     *
     * @param username
     * @return
     */
    private VmUsers getUserByUsername(String username, BasePo.Status status, BasePo.IsDeleted isDeleted) {
        //是否存在此username的user
        return vmUsersMapper.selectOneBy(ImmutableMap.of(
                "username", username,
                "isDeleted", isDeleted.getCode(),
                "status", status.getCode()
        ));
    }

    private VmUsers getUsableUserById(Long userId, BasePo.Status status, BasePo.IsDeleted isDeleted) {

        return QuickSelectOne.getObjectById(vmUsersMapper, userId, status, isDeleted);
    }

    private VmUsers getUsableUserById(Long userId, BasePo.IsDeleted isDeleted) {

        return QuickSelectOne.getObjectById(vmUsersMapper, userId, isDeleted);
    }

    @Override
    public void userLogout(String token) throws Exception {

//        Long userId = (Long) SessionManager.getOnlineUserId(token);

        SessionCacheManager.userLogout(token);

    }

    @Override
    public VmUsersDto getOnlineUser(String token) throws Exception {

        if (null == token) {
            return null;
        }
        Long userId = SessionCacheManager.getOnlineUserId(token);

        if (null == userId) {
            return null;
        }
        VmUsers vmUsers = this.getUsableUserById(userId, BasePo.Status.NORMAL, BasePo.IsDeleted.NO);
        if (null == vmUsers) {
            return null;
        }
        //get db use
        VmUsersDto dbUser = makeVmUsersDto(vmUsers, token);

        return dbUser;
    }

    @Override
    public List<VmUsersDto> userList(VmUserQueryBean query, PageBean page) {
        return customVmUsersMapper.getUserList(query, page).stream().parallel().map(vmUsers -> {
            return makeBackendVmUsersDto(vmUsers);
        }).collect(toList());
    }

    private VmUsersDto makeBackendVmUsersDto(VmUsers vmUsers) {
        VmUsersDto vmUsersDto = new VmUsersDto();
        vmUsersDto.setUsername(vmUsers.getUsername());
        vmUsersDto.setId(vmUsers.getId());
        vmUsersDto.setBirthday(vmUsers.getBirthday());
        vmUsersDto.setDescription(vmUsers.getDescription());
        vmUsersDto.setSex(vmUsers.getSex());
        vmUsersDto.setImgUrl(vmUsers.getImgUrl());
        vmUsersDto.setPassword(vmUsers.getPassword());
        vmUsersDto.setCreateTime(vmUsers.getCreateTime());
        vmUsersDto.setUpdateTime(vmUsers.getUpdateTime());
        vmUsersDto.setStatus(vmUsers.getStatus());
        return vmUsersDto;
    }

    @Override
    public Long userListTotal(VmUserQueryBean query, PageBean page) {
        return customVmUsersMapper.getUserListTotal(query, page);
    }

    @Override
    public VmUsersDto addUser(VmUsersDto vmUsersDto) {
        VmUsers dbUser = this.getUserByUsername(vmUsersDto.getUsername(), BasePo.IsDeleted.NO);

        if (!isNullObject(dbUser)) {
            throw new VmUsersException("addUser username is exits !! vmUsersDto is :" + vmUsersDto,
                    VmUsersException.ErrorCode.USERNAME_IS_EXITS.getCode(),
                    VmUsersException.ErrorCode.USERNAME_IS_EXITS.getMsg());
        }
        String imgUrl = VmUsers.DEFAULT_IMG_URL;

        VmUsers vmUsers = makeAddUser(vmUsersDto, imgUrl);

        if (1 != vmUsersMapper.insert(vmUsers)) {
            throw new VmUsersException("addUser vmUsersMapper#insert is fail !! vmUsersDto is :" + vmUsersDto);
        }


        //get new user
        vmUsers = this.getUsableUserById(vmUsers.getId(), BasePo.IsDeleted.NO);

        return makeBackendVmUsersDto(vmUsers);
    }

    @Override
    public VmUsersDto editUser(VmUsersDto vmUsersDto) {
        VmUsers dbUser = this.getUsableUserById(vmUsersDto.getId(), BasePo.IsDeleted.NO);
        if (!dbUser.getUsername().equals(vmUsersDto.getUsername())) {//if change username
            dbUser = this.getUserByUsername(vmUsersDto.getUsername(), BasePo.IsDeleted.NO);
            if (!isNullObject(dbUser)) {
                throw new VmUsersException("editUser username is exits !! vmUsersDto is :" + vmUsersDto,
                        VmUsersException.ErrorCode.USERNAME_IS_EXITS.getCode(),
                        VmUsersException.ErrorCode.USERNAME_IS_EXITS.getMsg());
            }
        }

        String imgUrl = VmUsers.DEFAULT_IMG_URL;
        VmUsers vmUsers = makeEditUser(vmUsersDto, imgUrl);

        if (1 != vmUsersMapper.update(vmUsers.getId(), vmUsers)) {
            throw new VmUsersException("editUser vmUsersMapper#update is fail !! vmUsersDto is :" + vmUsersDto);
        }

        //get new user
        vmUsers = this.getUsableUserById(vmUsers.getId(), BasePo.IsDeleted.NO);
        return makeBackendVmUsersDto(vmUsers);
    }

    @Override
    public VmUsersDto updateUserHeadImg(UpdateHeadImgInfo updateHeadImgInfo) throws Exception {
        //set versions
        updateHeadImgInfo.setVersions(userConfig.getUserImgVersions());

        //feign
        String res = srcServiceClient.cutUploadedImgFile(BeanMapUtil.beanToMap(updateHeadImgInfo));
        Response response = Response.parseJSON(res);
        if (response.isFailure()) {
            throw new VmUsersException("updateUserHeadImg srcServiceClient#cutUploadedImgFile is fail !! updateHeadImgInfo is :" + updateHeadImgInfo);
        }
        String imgUrl = (String) response.getData("imgUrl");
        //update user
        VmUsers vmUsers = new VmUsers();
        vmUsers.setId(updateHeadImgInfo.getId());
        vmUsers.setImgUrl(imgUrl);
        vmUsersMapper.update(vmUsers.getId(), vmUsers);


        //get new user
        vmUsers = this.getUsableUserById(vmUsers.getId(), BasePo.IsDeleted.NO);

        return vmUsers == null ? null : makeBackendVmUsersDto(vmUsers);
    }

    @Override
    @Transactional
    public void deleteUser(VmUsersDto vmUsersDto) {
        String deletedIdsStr = vmUsersDto.getDeletedIds();
        if (isEmptyString(deletedIdsStr)) {
            throw new VmUsersException("deleteUser deleteIdsStr is empty ! deleteIdsStr is : " + deletedIdsStr);
        }


        List<Long> deletedIds = parseStringArray2Long(vmUsersDto.getDeletedIds());
        if (isEmptyList(deletedIds)) {
            throw new VmUsersException("deleteUser deleteIds is empty ! deleteIds is : " + deletedIds);
        }
        if (deletedIds.size() != vmUsersMapper.updateInIds(deletedIds, ImmutableMap.of(
                "isDeleted", BasePo.IsDeleted.YES.getCode()
        ))) {
            throw new VmUsersException("deleteUser is fail ! deleteIds is : " + deletedIds);
        }
    }

    private VmUsers makeEditUser(VmUsersDto vmUsersDto, String imgUrl) {
        Integer now = DateUtil.unixTime().intValue();
        VmUsers vmUsers = new VmUsers();
        vmUsers.setBirthday(vmUsersDto.getBirthday());
        vmUsers.setDescription(vmUsersDto.getDescription());
//        vmUsers.setImgUrl(imgUrl);
        vmUsers.setPassword(vmUsersDto.getPassword());
        vmUsers.setSex(vmUsersDto.getSex());
        vmUsers.setStatus(vmUsersDto.getStatus());
        vmUsers.setUsername(vmUsersDto.getUsername());
        vmUsers.setId(vmUsersDto.getId());
        vmUsers.setUpdateTime(now);
        return vmUsers;
    }

    private VmUsers makeAddUser(VmUsersDto vmUsersDto, String imgUrl) {
        Integer now = DateUtil.unixTime().intValue();
        VmUsers vmUsers = new VmUsers();
        vmUsers.setBirthday(vmUsersDto.getBirthday());
        vmUsers.setDescription(vmUsersDto.getDescription());
        vmUsers.setImgUrl(imgUrl);
        vmUsers.setPassword(vmUsersDto.getPassword());
        vmUsers.setSex(vmUsersDto.getSex());
        vmUsers.setStatus(vmUsersDto.getStatus());
        vmUsers.setUsername(vmUsersDto.getUsername());
        vmUsers.setIsDeleted(BasePo.IsDeleted.NO.getCode());
        vmUsers.setCreateTime(now);
        vmUsers.setUpdateTime(now);
        return vmUsers;
    }

    private VmUsers makeRegistVmUserPo(VmUsersDto user) {
        VmUsers vmUsers = new VmUsers();
        vmUsers.setUsername(user.getUsername());
        vmUsers.setPassword(user.getPassword());
        vmUsers.setUpdateTime(DateUtil.unixTime().intValue());
        vmUsers.setCreateTime(DateUtil.unixTime().intValue());
        vmUsers.setStatus(VmUsers.Status.NORMAL.getCode());
        vmUsers.setSex(VmUsers.Sex.UNKNOWN.getCode());
        vmUsers.setImgUrl(VmUsers.DEFAULT_IMG_URL);//暂时搁置
        return vmUsers;
    }


}

