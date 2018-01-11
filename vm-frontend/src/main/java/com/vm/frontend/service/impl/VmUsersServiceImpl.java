package com.vm.frontend.service.impl;

import com.vm.base.utils.BaseService;
import com.vm.base.utils.DateUtil;
import com.vm.base.utils.VmProperties;
import com.vm.dao.mapper.VmFilesMapper;
import com.vm.dao.mapper.VmUsersMapper;
import com.vm.dao.po.BasePo;
import com.vm.dao.po.VmFiles;
import com.vm.dao.po.VmUsers;
import com.vm.dao.po.VmUsersExample;
import com.vm.frontend.service.dto.VmUsersDto;
import com.vm.frontend.service.exception.VmUsersException;
import com.vm.frontend.service.inf.VmUsersService;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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
        VmUsersExample example = new VmUsersExample();
        VmUsersExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(username);
        criteria.andStatusEqualTo(BasePo.Status.NORMAL.getCode());
        List<VmUsers> vmUsers = vmUsersMapper.selectByExample(example);
        if (isEmptyList(vmUsers)) {
            return null;
        }
        return vmUsers.get(0);
    }

    private VmUsersDto makeVmUsersBo(VmUsers user) {
        VmUsersDto vmUsersBo = new VmUsersDto();
        vmUsersBo.setUsername(user.getUsername());
        vmUsersBo.setId(user.getId());
        vmUsersBo.setBirthday(user.getBirthday());
        vmUsersBo.setDescription(user.getDescription());
        vmUsersBo.setSex(user.getSex());
        vmUsersBo.setImgUrl(user.getImgUrl());
        return vmUsersBo;
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

        return makeVmUsersBo(dbUser);
    }

    @Override
    public VmUsersDto getUserBasicInfo(Long userId) {

        //获取指定id的user

        VmUsers dbUser = vmUsersMapper.selectByPrimaryKey(userId);

        if (isNullObject(dbUser) || VmUsers.Status.isDeleted(dbUser.getStatus())) {
            logger.error("getUserBasicInfo user is not exits! userId is : {}", userId);
            throw new VmUsersException(VmUsersException.ErrorCode.USER_IS_NOT_EXITS.getCode(), VmUsersException.ErrorCode.USER_IS_NOT_EXITS.getMsg());
        }


        return makeVmUsersBo(dbUser);
    }


    @Override
    @Transactional
    public VmUsersDto updateOnlineUserBasicInfo(VmUsersDto user) throws Exception {
        //user是否存在
        VmUsers dbUser = vmUsersMapper.selectByPrimaryKey(user.getId());

        if (isNullObject(dbUser) || VmUsers.Status.isDeleted(dbUser.getStatus())) {
            logger.error("updateOnlineUserBasicInfo dbUser is not exits ! user is : {}", user);
            throw new VmUsersException(VmUsersException.ErrorCode.USER_IS_NOT_EXITS.getCode(), VmUsersException.ErrorCode.USER_IS_NOT_EXITS.getMsg());
        }


        vmUsersMapper.updateByPrimaryKeySelective(makeUpdateOnlineVmUsers(user));

        return makeVmUsersBo(vmUsersMapper.selectByPrimaryKey(user.getId()));
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
        FileInputStream input = null;
        ServletOutputStream output = null;
        try {
            //获取用户图片id信息
            VmFiles file = vmFilesMapper.selectByPrimaryKey(fileId);
            String userImgPath = VmProperties.VM_USER_IMG_PATH;
            String userImgName = null;
            String contentType = null;
            if (file != null) {
                contentType = file.getContentType();
                userImgName = file.getFilename();
            }
            File f = new File(userImgPath + File.separator + width + "_" + userImgName);
            //不存在，返回默认图片
            if (!f.exists()) {
                f = new File(userImgPath + File.separator + VmProperties.VM_USER_IMG_DEFAULT_NAME);
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
        return makeVmUsersBo(vmUsers);
    }

    @Override
    public String saveUserTempHeadImg(Long userId, MultipartFile headImg) throws Exception {
        InputStream inputStream = null;
        OutputStream outputStream = null;
        String targetHeadImgName = null;
        try {
            String targetPath = VmProperties.VM_USER_IMG_TEMP_PATH;
            String contentType = headImg.getContentType();
            if (!contentType.equals(MediaType.IMAGE_JPEG_VALUE)) {
                logger.error("saveUserTempHeadImg headImg contentType is error ! headImg is : {}", headImg);
                throw new VmUsersException(VmUsersException.ErrorCode.USER_HEAD_IMG_CONTENT_TYPE_ERROR.getCode(),
                        VmUsersException.ErrorCode.USER_HEAD_IMG_CONTENT_TYPE_ERROR.getMsg());
            }
            //get ext
            String ext = getFileNameExt(headImg.getOriginalFilename());
            targetHeadImgName = File.separator + userId + "." + ext;
            String headImgName = targetPath + targetHeadImgName;
            //save head Img
            inputStream = headImg.getInputStream();
            outputStream = new FileOutputStream(headImgName);
            org.apache.commons.io.IOUtils.copy(inputStream, outputStream);
        } catch (VmUsersException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeStream(inputStream, outputStream);
        }
        return targetHeadImgName;
    }

    @Override
    public void getUserTempHeadImg(String fileName, HttpServletResponse response) throws Exception {
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            String targetPath = VmProperties.VM_USER_IMG_TEMP_PATH;
            String headImgName = targetPath + fileName;
            inputStream = new FileInputStream(headImgName);
            org.apache.commons.io.IOUtils.copy(inputStream, response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeStream(inputStream, outputStream);
        }

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
