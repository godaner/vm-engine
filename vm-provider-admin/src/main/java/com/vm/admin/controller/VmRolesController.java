package com.vm.admin.controller;

import com.vm.admin.dao.qo.VmRolesQueryBean;
import com.vm.admin.service.dto.VmRolesDto;
import com.vm.admin.service.inf.VmRolesService;
import com.vm.base.aop.RequiredAuth;
import com.vm.base.util.ServiceController;
import com.vm.dao.util.PageBean;
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
@RequestMapping("/admin/role")
@Scope("prototype")
public class VmRolesController extends ServiceController<VmRolesService> {

    /**
     * 获取列表
     *
     * @return
     */
    @RequiredAuth(auths = {"role:select"})
    @RequestMapping(value = "/info/list", method = RequestMethod.GET)
    @ResponseBody
    public Object getRoles(PageBean page, VmRolesQueryBean query) throws Exception {

        return response.putData("list", service.getRoles(page, query)).putData("total", service.getRolesTotal(page, query));
    }

    /**
     * 获取所有
     *
     * @return
     */
    @RequestMapping(value = "/info/all", method = RequestMethod.GET)
    @ResponseBody
    public Object getAllRoles() throws Exception {

        return response.putData("list", service.getAllRoles());
    }

    /**
     * 获取列表
     *
     * @return
     */
    @RequestMapping(value = "/id/list/byAdminId/{adminId}", method = RequestMethod.GET)
    @ResponseBody
    public Object getRoleIdsByAdminId(@PathVariable("adminId") Long adminId) throws Exception {

        return response.putData("list", service.getRoleIdsByAdminId(adminId));
    }

    /**
     * 添加
     *
     * @return
     */
    @RequestMapping(value = "/info", method = RequestMethod.POST)
    @ResponseBody
    public Object addRole(VmRolesDto vmRolesDto) throws Exception {

        return response.putData("role", service.addRole(vmRolesDto));
    }

    /**
     * 更新
     *
     * @return
     */
    @RequestMapping(value = "/info", method = RequestMethod.PUT)
    @ResponseBody
    public Object editRole(VmRolesDto vmRolesDto) throws Exception {

        return response.putData("role", service.editRole(vmRolesDto));
    }
}
