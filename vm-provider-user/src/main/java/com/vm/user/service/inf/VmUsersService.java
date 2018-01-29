package com.vm.user.service.inf;


import com.vm.user.service.dto.UpdateHeadImgInfo;
import com.vm.user.service.dto.VmUsersDto;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by ZhangKe on 2017/12/18.
 */
public interface VmUsersService {

    VmUsersDto userLogin(VmUsersDto vmUsersDto) throws Exception;

    VmUsersDto getUserBasicInfo(Long userId) throws Exception;

    VmUsersDto updateOnlineUserBasicInfo(VmUsersDto user) throws Exception;

    void sendUserImg(Long fileId, Integer width, HttpServletResponse response) throws Exception;

    VmUsersDto userRegist(VmUsersDto user) throws Exception;

    Long saveUserTempHeadImg(Long onlineUserId, MultipartFile headImg) throws Exception;

    void getUserTempHeadImg(Long fileId, HttpServletResponse response) throws Exception;

    VmUsersDto updateUserHeadImg(Long onlineUserId, UpdateHeadImgInfo updateHeadImgInfo) throws Exception;

    void userLogout(String token) throws Exception;

    VmUsersDto getOnlineUser(String token) throws Exception;
}
