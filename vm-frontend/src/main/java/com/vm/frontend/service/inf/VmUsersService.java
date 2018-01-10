package com.vm.frontend.service.inf;

import com.vm.frontend.service.dto.VmUsersDto;

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
}
