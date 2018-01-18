package com.vm.frontend.service.impl;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.vm.base.util.BaseService;
import com.vm.base.util.DateUtil;
import com.vm.base.util.ImageUtil;
import com.vm.base.util.ServerConfig;
import com.vm.dao.mapper.VmFilesMapper;
import com.vm.dao.mapper.VmUsersMapper;
import com.vm.dao.po.BasePo;
import com.vm.dao.po.VmFiles;
import com.vm.dao.po.VmUsers;
import com.vm.frontend.service.dto.UpdateHeadImgInfo;
import com.vm.frontend.service.dto.VmUsersDto;
import com.vm.frontend.service.exception.VmUsersException;
import com.vm.frontend.service.inf.VmUsersService;
import com.vm.frontend.util.SessionManager;
import com.vm.frontend.websocket.OnlineUsersWebSocket;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

/**
 * Created by ZhangKe on 2017/12/28.
 */
@Service
public class VmUsersServiceImpl extends BaseService implements VmUsersService {
    @Autowired
    private VmUsersMapper vmUsersMapper;

    @Autowired
    private VmFilesMapper vmFilesMapper;

    /**
     * 通过username获取user
     *
     * @param username
     * @return
     */
    private VmUsers getUserByUsername(String username) {
        //是否存在此username的user
        VmUsers vmUsers = vmUsersMapper.selectOneBy(ImmutableMap.of(
                "status", BasePo.Status.NORMAL.getCode(),
                username, username
        ));
        if (isNullObject(vmUsers)) {
            return null;
        }
        return vmUsers;
    }

    private VmUsersDto makeVmUsersDto(VmUsers user,String token) {
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
        VmUsers dbUser = getUserByUsername(vmUsersDto.getUsername());

        if (isNullObject(dbUser)) {
            logger.error("userLogin dbUser is not exits ! user is : {}", vmUsersDto);
            throw new VmUsersException(VmUsersException.ErrorCode.USER_IS_NOT_EXITS.getCode(), VmUsersException.ErrorCode.USER_IS_NOT_EXITS.getMsg());
        }
        if (!dbUser.getPassword().equals(vmUsersDto.getPassword())) {
            logger.error("userLogin password is error ! user is :  {}", vmUsersDto);
            throw new VmUsersException(VmUsersException.ErrorCode.PASSWORD_ERROR.getCode(), VmUsersException.ErrorCode.USER_IS_NOT_EXITS.getMsg());
        }

        String  token = SessionManager.userLogin(dbUser.getId());

        return makeVmUsersDto(dbUser,token);
    }

    @Override
    public VmUsersDto getUserBasicInfo(Long userId) {

        //获取指定id的user
        VmUsers dbUser = vmUsersMapper.select(userId);

        if (isNullObject(dbUser) || VmUsers.Status.isDeleted(dbUser.getStatus())) {
            logger.error("getUserBasicInfo user is not exits! userId is : {}", userId);
            throw new VmUsersException(VmUsersException.ErrorCode.USER_IS_NOT_EXITS.getCode(), VmUsersException.ErrorCode.USER_IS_NOT_EXITS.getMsg());
        }


        return makeVmUsersDto(dbUser);
    }


    @Override
    @Transactional
    public VmUsersDto updateOnlineUserBasicInfo(VmUsersDto user) throws Exception {
        //user是否存在
        VmUsers dbUser = vmUsersMapper.select(user.getId());

        if (isNullObject(dbUser) || VmUsers.Status.isDeleted(dbUser.getStatus())) {
            logger.error("updateOnlineUserBasicInfo dbUser is not exits ! user is : {}", user);
            throw new VmUsersException(VmUsersException.ErrorCode.USER_IS_NOT_EXITS.getCode(), VmUsersException.ErrorCode.USER_IS_NOT_EXITS.getMsg());
        }


        vmUsersMapper.update(makeUpdateOnlineVmUsers(user));

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

        if (isNullObject(width)) {
            logger.error("sendUserImg width is null ! fileId is : {} , width is : {}", fileId, width);
            throw new VmUsersException(VmUsersException.ErrorCode.USER_HEAD_IMG_WIDTH_IS_NULL.getCode(),
                    VmUsersException.ErrorCode.USER_HEAD_IMG_WIDTH_IS_NULL.getMsg());
        }
        FileInputStream input = null;
        ServletOutputStream output = null;
        try {
            //获取用户图片id信息
            VmFiles file = vmFilesMapper.select(fileId);
            String userImgPath = ServerConfig.VM_USER_IMG_PATH;
            String userImgName = null;
            String contentType = null;
            if (file != null) {
                contentType = file.getContentType();
                userImgName = file.getFilename();
            }
            if (width == null) {
                width = 300;
            }
            File f = new File(userImgPath + File.separator + width + "_" + userImgName);
            //不存在，返回默认图片
            if (!f.exists()) {
                f = new File(userImgPath + File.separator + ServerConfig.VM_USER_IMG_DEFAULT_NAME);
            }
            output = response.getOutputStream();
            input = new FileInputStream(f);
            //设置响应的媒体类型

            response.setContentType(contentType); // 设置返回的文件类型
            IOUtils.copy(input, output);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeStream(input, output);
        }
    }

    @Override
    @Transactional
    public VmUsersDto userRegist(VmUsersDto user) throws Exception {

        //是否存在username相同的账户
        if (!isNullObject(getUserByUsername(user.getUsername()))) {
            logger.error("userRegist username is exits ! user is :  {}", user);
            throw new VmUsersException(VmUsersException.ErrorCode.USER_IS_NOT_EXITS.getCode(), VmUsersException.ErrorCode.USER_IS_NOT_EXITS.getMsg());
        }

        vmUsersMapper.insert(makeRegistVmUserPo(user));
        VmUsers vmUsers = getUserByUsername(user.getUsername());

        String token = SessionManager.userLogin(vmUsers.getId());
        return makeVmUsersDto(vmUsers,token);
    }

    @Override
    @Transactional
    public Long saveUserTempHeadImg(Long userId, MultipartFile headImg) throws Exception {
        InputStream inputStream = null;
        OutputStream outputStream = null;
        String targetHeadImgName = null;
        String targetHeadImgPathName = null;
        VmFiles vmFiles = null;
        try {
            //targetPath
            String targetPath = ServerConfig.VM_USER_IMG_TEMP_PATH;
            //contentType
            String contentType = headImg.getContentType();
            //originalFilename
            String originalFilename = headImg.getOriginalFilename();
            //exts
            List<String> exts = Lists.newArrayList(ServerConfig.VM_USER_TEMP_IMG_EXTS.split(","));
            //get ext
            String ext = getFileNameExt(originalFilename);
            //get size
            Long size = headImg.getSize();
            //now
            Integer now = DateUtil.unixTime().intValue();

            if (!exts.contains(ext)) {
                logger.error("saveUserTempHeadImg headImg ext is error ! headImg is : {}", headImg);
                throw new VmUsersException(VmUsersException.ErrorCode.USER_HEAD_IMG_CONTENT_TYPE_ERROR.getCode(),
                        VmUsersException.ErrorCode.USER_HEAD_IMG_CONTENT_TYPE_ERROR.getMsg());
            }
            targetHeadImgName = userId + "." + ext;
            targetHeadImgPathName = targetPath + File.separator + targetHeadImgName;
            //save head Img
            inputStream = headImg.getInputStream();
            outputStream = new FileOutputStream(targetHeadImgPathName);
            org.apache.commons.io.IOUtils.copy(inputStream, outputStream);


            //写入数据库
            vmFiles = new VmFiles();

            vmFiles.setUpdateTime(now);
            vmFiles.setCreateTime(now);
            vmFiles.setSize(size);
            vmFiles.setStatus(BasePo.Status.NORMAL.getCode());
            vmFiles.setOriginalName(originalFilename);
            vmFiles.setFilename(targetHeadImgName);
            vmFiles.setContentType(contentType);
            vmFilesMapper.insert(vmFiles);

        } catch (Exception e) {
            e.printStackTrace();
            deleteFiles(targetHeadImgName);
        } finally {
            closeStream(inputStream, outputStream);
        }
        return vmFiles.getId();
    }

    @Override
    public void getUserTempHeadImg(Long fileId, HttpServletResponse response) throws Exception {
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {

            VmFiles vmFiles = vmFilesMapper.select(fileId);
            String targetPath = ServerConfig.VM_USER_IMG_TEMP_PATH;
            String targetHeadImgPathName = targetPath + File.separator + vmFiles.getFilename();
            inputStream = new FileInputStream(targetHeadImgPathName);
            org.apache.commons.io.IOUtils.copy(inputStream, response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeStream(inputStream, outputStream);
        }

    }

    @Override
    @Transactional
    public VmUsersDto updateUserHeadImg(Long onlineUserId, UpdateHeadImgInfo updateHeadImgInfo) throws Exception {
        String sourceFilePathName = null;
        String sourceFileName = null;
        VmUsers vmUsers = null;
        VmFiles vmFiles = null;
        try {

            //now
            Integer now = DateUtil.unixTime().intValue();
            //vmFiles
            vmFiles = vmFilesMapper.select(updateHeadImgInfo.getFileId());
            //sourceFileName
            sourceFileName = vmFiles.getFilename();
            //sourceFilePathName
            sourceFilePathName = ServerConfig.VM_USER_IMG_TEMP_PATH + File.separator + sourceFileName;

            //数据库保存的图片名
            String ext = getFileNameExt(sourceFileName);
            String uuid = uuid();
            String newFileName = uuid + "." + ext;

            //写入多版本文件
            final String finalSourceFilePath = sourceFilePathName;
            String[] versions = ServerConfig.VM_USER_IMG_VERSIONS.split(",");
            Lists.newArrayList(versions).stream().parallel().forEach((version) -> {
                String targetFilePath = ServerConfig.VM_USER_IMG_PATH + File.separator + version + "_" + newFileName;
                try {
                    ImageUtil.cutImage(finalSourceFilePath,
                            targetFilePath,
                            updateHeadImgInfo.getX(),
                            updateHeadImgInfo.getY(),
                            updateHeadImgInfo.getWidth(),
                            updateHeadImgInfo.getHeight(),
                            ext);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            //save File
//            vmFiles = new VmFiles();
            vmFiles.setId(null);
            vmFiles.setCreateTime(now);
            vmFiles.setUpdateTime(now);
            vmFiles.setFilename(newFileName);
//            vmFiles.setOriginalName(vmFiles.getOriginalName());
//            vmFiles.setStatus(VmFiles.Status.NORMAL.getCode());
//            vmFiles.setSize(0l);
            vmFilesMapper.insert(vmFiles);


            //update user
            vmUsers = new VmUsers();
            vmUsers.setId(onlineUserId);
            vmUsers.setImgUrl(ServerConfig.VM_USER_IMG_URL_PREFIX + "/" + vmFiles.getId());
            vmUsersMapper.update(vmUsers);


            //get new user
            vmUsers = vmUsersMapper.select(onlineUserId);
            vmUsers = (vmUsers == null || BasePo.Status.isDeleted(vmUsers.getStatus())) ? null : vmUsers;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            deleteFiles(sourceFilePathName);
        }
        return vmUsers == null ? null : makeVmUsersDto(vmUsers);

    }

    @Override
    public void userLogout(String token) throws Exception {

        Long userId = (Long) SessionManager.getOnlineUserInfo(token);

        SessionManager.userLogout(token);

        OnlineUsersWebSocket.userLogout(userId, OnlineUsersWebSocket.Result.LOGOUT_SUCCESS.getCode());

    }

    @Override
    public VmUsersDto getOnlineUser(String token) throws Exception {

        Long userId = (Long) SessionManager.getOnlineUserInfo(token);

        //get db use
        VmUsersDto dbUser = makeVmUsersDto(vmUsersMapper.select(userId),token);

        return dbUser;
    }

    private VmUsers makeRegistVmUserPo(VmUsersDto user) {
        VmUsers vmUsers = new VmUsers();
        vmUsers.setUsername(user.getUsername());
        vmUsers.setPassword(user.getPassword());
        vmUsers.setUpdateTime(DateUtil.unixTime().intValue());
        vmUsers.setCreateTime(DateUtil.unixTime().intValue());
        vmUsers.setStatus(VmUsers.Status.NORMAL.getCode());
        vmUsers.setSex(VmUsers.Sex.UNKNOWN.getCode());
        vmUsers.setImgUrl(VmUsers.USER_IMG_URL_PREFIX);
        return vmUsers;
    }


}
