package com.vm.frontend.service.inf;

import com.vm.dao.po.CustomVmUsers;
import com.vm.dao.po.VmUsers;
import com.vm.dao.qo.VmMoviesQueryBean;
import com.vm.frontend.service.bo.VmUsersBo;
import com.vm.frontend.service.vo.VmUsersVo;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by ZhangKe on 2017/12/18.
 */
public interface VmUsersService {

    VmUsersBo userLogin(VmUsersVo user) throws Exception;

    VmUsersBo getUserBasicInfo(Long userId) throws Exception;

    VmUsersBo updateOnlineUserBasicInfo(VmUsersVo user) throws Exception;

    void sendUserImg(Long fileId, Integer width, HttpServletResponse response) throws Exception;

    VmUsersBo userRegist(VmUsersVo user) throws Exception;
}
