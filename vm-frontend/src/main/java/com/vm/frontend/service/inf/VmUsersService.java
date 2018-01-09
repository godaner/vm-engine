package com.vm.frontend.service.inf;

import com.vm.dao.po.CustomVmUsers;
import com.vm.dao.po.VmUsers;
import com.vm.dao.qo.VmMoviesQueryBean;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by ZhangKe on 2017/12/18.
 */
public interface VmUsersService {

    VmUsers userLogin(CustomVmUsers user) throws Exception;

    VmUsers getUserBasicInfo(Long userId) throws Exception;

    VmUsers updateOnlineUserBasicInfo(CustomVmUsers user) throws Exception;

    void sendUserImg(Long fileId, VmMoviesQueryBean query, HttpServletResponse response) throws Exception;

    VmUsers userRegist(CustomVmUsers user) throws Exception;
}
