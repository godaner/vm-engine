package com.vm.admin.controller;

import com.vm.admin.service.inf.VmAuthsService;
import com.vm.base.util.ServiceController;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by ZhangKe on 2018/3/26.
 */
@Controller
@RequestMapping("/admin/auth")
@Scope("prototype")
public class VmAuthsController extends ServiceController<VmAuthsService> {

    /**
     * 获取列表
     *
     * @return
     */
    @RequestMapping(value = "/info/all", method = RequestMethod.GET)
    @ResponseBody
    public Object getAllAuths() throws Exception {

        return response.putData("list", service.getAllAuths());
    }

    /**
     * 获取角色权限id列表
     *
     * @return
     */
    @RequestMapping(value = "/id/list/byRoleId/{roleId}", method = RequestMethod.GET)
    @ResponseBody
    public Object getAuthIdsByRoleId(@PathVariable("roleId") Long roleId) throws Exception {

        return response.putData("list", service.getAuthIdsByRoleId(roleId));
    }

}
