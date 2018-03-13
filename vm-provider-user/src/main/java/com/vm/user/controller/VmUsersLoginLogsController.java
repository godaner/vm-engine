package com.vm.user.controller;

import com.vm.base.util.PageBean;
import com.vm.base.util.ServiceController;
import com.vm.user.aop.IgnoreExtendSessionLife;
import com.vm.user.aop.RequiredLogin;
import com.vm.user.dao.qo.VmUserQueryBean;
import com.vm.user.dao.qo.VmUsersLoginLogsQueryBean;
import com.vm.user.resolver.OnlineUser;
import com.vm.user.service.dto.UpdateHeadImgInfo;
import com.vm.user.service.dto.VmUsersDto;
import com.vm.user.service.inf.VmUsersLoginLogsService;
import com.vm.user.service.inf.VmUsersService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Created by ZhangKe on 2018/3/13.
 */
@Controller
@RequestMapping("/")
@Scope("prototype")
public class VmUsersLoginLogsController extends ServiceController<VmUsersLoginLogsService> {
    /**
     * 获取用户登录记录列表<br/>
     *
     * @return
     */
    @RequestMapping(value = "/user/login/logs", method = RequestMethod.GET)
    @ResponseBody
    public Object getUserLoginLogs(VmUsersLoginLogsQueryBean query, PageBean page) throws Exception {
        return response.putData("list", service.getUserLoginLogs(query,page)).
                putData("total", service.getUserLoginLogsTotal(query,page));
    }
}

