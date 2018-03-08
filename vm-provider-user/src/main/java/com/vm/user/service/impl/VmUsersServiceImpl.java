package com.vm.user.service.impl;

import com.google.common.collect.ImmutableMap;
import com.vm.base.util.*;
import com.vm.user.config.UserConfig;
import com.vm.user.dao.mapper.VmUsersMapper;
import com.vm.user.dao.mapper.custom.CustomVmUsersMapper;
import com.vm.user.dao.po.VmUsers;
import com.vm.user.dao.qo.VmUserQueryBean;
import com.vm.user.feign.service.SrcServiceClient;
import com.vm.user.service.dto.UpdateHeadImgInfo;
import com.vm.user.service.dto.VmUsersDto;
import com.vm.user.service.exception.VmUsersException;
import com.vm.user.service.inf.VmUsersService;
import com.vm.user.util.SessionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;
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
    private CustomVmUsersMapper customVmUsersMapper;

    @Autowired
    private SrcServiceClient srcServiceClient;
    @Autowired
    private UserConfig userConfig;

    /**
     * 通过username获取user
     *
     * @param username
     * @return
     */
    private VmUsers getUserByUsername(String username, Byte status) {
        //是否存在此username的user
        return vmUsersMapper.selectOneBy(ImmutableMap.of(
                "status", status,
                "username", username,
                "isDeleted", BasePo.IsDeleted.NO.getCode()
        ));
    }

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
    public VmUsersDto userLogin(VmUsersDto vmUsersDto) throws Exception {

        //user是否存在
        VmUsers dbUser = this.getUserByUsername(vmUsersDto.getUsername(), BasePo.Status.NORMAL.getCode());

        if (isNullObject(dbUser)) {
            throw new VmUsersException("userLogin dbUser is not exits ! user is : " + vmUsersDto,
                    VmUsersException.ErrorCode.USER_IS_NOT_EXITS.getCode(), VmUsersException.ErrorCode.USER_IS_NOT_EXITS.getMsg());
        }
        if (!dbUser.getPassword().equals(vmUsersDto.getPassword())) {
            throw new VmUsersException("userLogin password is error ! user is :  " + vmUsersDto,
                    VmUsersException.ErrorCode.PASSWORD_ERROR.getCode(), VmUsersException.ErrorCode.USER_IS_NOT_EXITS.getMsg());
        }

        //login in session
        SessionManager.UserInfo userInfo = new SessionManager.UserInfo();
        userInfo.setId(dbUser.getId());
        userInfo.setUsername(dbUser.getUsername());
        String token = SessionManager.userLogin(userInfo);

        return makeVmUsersDto(dbUser, token);
    }

    @Override
    public VmUsersDto getUserBasicInfo(Long userId) {

        //获取指定id的user
        VmUsers dbUser = this.getUsableUserById(userId);

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
        VmUsers dbUser = this.getUsableUserById(user.getId());

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
        if (!isNullObject(this.getUserByUsername(user.getUsername(), BasePo.Status.NORMAL.getCode()))) {

            throw new VmUsersException("userRegist username is exits ! user is :  " + user,
                    VmUsersException.ErrorCode.USER_IS_NOT_EXITS.getCode(), VmUsersException.ErrorCode.USER_IS_NOT_EXITS.getMsg());
        }

        vmUsersMapper.insert(makeRegistVmUserPo(user));

        VmUsers vmUsers = getUserByUsername(user.getUsername(), BasePo.Status.NORMAL.getCode());


        //login in session
        SessionManager.UserInfo userInfo = new SessionManager.UserInfo();
        userInfo.setId(vmUsers.getId());
        userInfo.setUsername(vmUsers.getUsername());
        String token = SessionManager.userLogin(userInfo);

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
        vmUsers = this.getUsableUserById(vmUsers.getId());

        return vmUsers == null ? null : makeVmUsersDto(vmUsers);

    }

    private VmUsers getUsableUserById(Long userId) {
        VmUsers vmUsers = vmUsersMapper.select(userId);
        return (vmUsers == null || BasePo.IsDeleted.isDeleted(vmUsers.getIsDeleted()) || !BasePo.Status.isNormal(vmUsers.getStatus())) ? null : vmUsers;
    }

    @Override
    public void userLogout(String token) throws Exception {

//        Long userId = (Long) SessionManager.getOnlineUserId(token);

        SessionManager.userLogout(token);

    }

    @Override
    public VmUsersDto getOnlineUser(String token) throws Exception {

        if (null == token) {
            return null;
        }
        Long userId = (Long) SessionManager.getOnlineUserId(token);

        if (null == userId) {
            return null;
        }
        VmUsers vmUsers = this.getUsableUserById(userId);
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
        VmUsers normalUser = this.getUserByUsername(vmUsersDto.getUsername(), BasePo.Status.NORMAL.getCode());
        VmUsers frozenUser = this.getUserByUsername(vmUsersDto.getUsername(), BasePo.Status.FROZEN.getCode());
        if (!isNullObject(normalUser) || !isNullObject(frozenUser)) {
            throw new VmUsersException("addUser username is exits !! vmUsersDto is :" + vmUsersDto,
                    VmUsersException.ErrorCode.USERNAME_IS_EXITS.getCode(),
                    VmUsersException.ErrorCode.USERNAME_IS_EXITS.getMsg());
        }
        String imgUrl = VmUsers.DEFAULT_IMG_URL;

        VmUsers vmUsers = makeAddUser(vmUsersDto,imgUrl);

        if (1 != vmUsersMapper.insert(vmUsers)) {
            throw new VmUsersException("addUser vmUsersMapper#insert is fail !! vmUsersDto is :" + vmUsersDto);
        }

        return makeBackendVmUsersDto(vmUsers);
    }

    @Override
    public VmUsersDto editUser(VmUsersDto vmUsersDto) {
        VmUsers normalUser = this.getUserByUsername(vmUsersDto.getUsername(), BasePo.Status.NORMAL.getCode());
        VmUsers frozenUser = this.getUserByUsername(vmUsersDto.getUsername(), BasePo.Status.FROZEN.getCode());
        if (!isNullObject(normalUser) || !isNullObject(frozenUser)) {
            throw new VmUsersException("editUser username is exits !! vmUsersDto is :" + vmUsersDto,
                    VmUsersException.ErrorCode.USERNAME_IS_EXITS.getCode(),
                    VmUsersException.ErrorCode.USERNAME_IS_EXITS.getMsg());
        }

        String imgUrl = VmUsers.DEFAULT_IMG_URL;
        VmUsers vmUsers = makeEditUser(vmUsersDto,imgUrl);

        if (1 != vmUsersMapper.update(vmUsers.getId(),vmUsers)) {
            throw new VmUsersException("editUser vmUsersMapper#update is fail !! vmUsersDto is :" + vmUsersDto);
        }

        return makeBackendVmUsersDto(vmUsers);
    }

    private VmUsers makeEditUser(VmUsersDto vmUsersDto, String imgUrl) {
        Integer now = DateUtil.unixTime().intValue();
        VmUsers vmUsers = new VmUsers();
        vmUsers.setBirthday(vmUsersDto.getBirthday());
        vmUsers.setDescription(vmUsersDto.getDescription());
        vmUsers.setImgUrl(imgUrl);
        vmUsers.setPassword(vmUsersDto.getPassword());
        vmUsers.setSex(vmUsersDto.getSex());
        vmUsers.setStatus(vmUsersDto.getStatus());
        vmUsers.setUsername(vmUsersDto.getUsername());
        vmUsers.setUpdateTime(now);
        return vmUsers;
    }

    private VmUsers makeAddUser(VmUsersDto vmUsersDto,String imgUrl) {
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

