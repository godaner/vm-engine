package com.vm.service.inf;

import com.vm.dao.po.*;
import com.vm.dao.qo.PageBean;
import com.vm.dao.qo.VmMoviesQueryBean;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by ZhangKe on 2017/12/18.
 */
public interface VmUsersService {

    VmUsers userLogin(CustomVmUsers user) throws Exception;

    VmUsers getUserBasicInfo(Long userId) throws Exception;

    void updateUserBasicInfo(CustomVmUsers user) throws Exception;

    void sendUserImg(Long fileId, VmMoviesQueryBean query, HttpServletResponse response) throws Exception;

    VmUsers userRegist(CustomVmUsers user) throws Exception;
}
