package com.vm.admin.controller;

import com.vm.admin.dao.qo.VmAdminLoginLogsQueryBean;
import com.vm.admin.service.inf.VmAdminLoginLogsService;
import com.vm.base.util.ServiceController;
import com.vm.dao.util.PageBean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by ZhangKe on 2018/3/26.
 */
@Controller
@RequestMapping("/admin/login/logs")
@Scope("prototype")
public class VmAdminLoginLogsController extends ServiceController<VmAdminLoginLogsService> {

    /**
     * 获取用户登录记录列表<br/>
     *
     * @return
     */
    @RequestMapping(value = "/info/list", method = RequestMethod.GET)
    @ResponseBody
    public Object getLoginLogs(PageBean page, VmAdminLoginLogsQueryBean query) throws Exception {
        return response.putData("list", service.getLoginLogs(page, query)).
                putData("total", service.getLoginLogsTotal(page, query));
    }
}
