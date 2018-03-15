package com.vm.user.service.inf;


import com.vm.base.service.dto.UpdateHeadImgInfo;
import com.vm.base.util.PageBean;
import com.vm.user.dao.qo.VmUserQueryBean;
import com.vm.user.service.dto.VmUsersDto;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by ZhangKe on 2017/12/18.
 */
public interface VmUsersService {

    VmUsersDto userLogin(VmUsersDto vmUsersDto) throws Exception;

    VmUsersDto getUserBasicInfo(Long userId) throws Exception;

    VmUsersDto updateOnlineUserBasicInfo(VmUsersDto user) throws Exception;

    void sendUserImg(Long fileId, Integer width, HttpServletResponse response) throws Exception;

    VmUsersDto userRegist(VmUsersDto user) throws Exception;

    void getUserTempHeadImg(Long fileId, HttpServletResponse response) throws Exception;

    VmUsersDto updateUserHeadImg(Long onlineUserId, UpdateHeadImgInfo updateHeadImgInfo) throws Exception;

    void userLogout(String token) throws Exception;

    VmUsersDto getOnlineUser(String token) throws Exception;

    List<VmUsersDto> userList(VmUserQueryBean query, PageBean page) throws Exception;

    Long userListTotal(VmUserQueryBean query, PageBean page) throws Exception;

    VmUsersDto addUser(VmUsersDto vmUsersDto) throws Exception;

    VmUsersDto editUser(VmUsersDto vmUsersDto) throws Exception;

    VmUsersDto updateUserHeadImg(UpdateHeadImgInfo updateHeadImgInfo) throws Exception;

    void deleteUser(VmUsersDto vmUsersDto);

}
