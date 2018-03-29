package com.vm.admin.controller;

import com.vm.admin.dao.qo.VmRolesQueryBean;
import com.vm.admin.service.dto.VmRolesDto;
import com.vm.admin.service.inf.VmRolesService;
import com.vm.base.aop.RequiredAdminLogin;
import com.vm.base.aop.RequiredAuth;
import com.vm.base.util.ServiceController;
import com.vm.dao.util.PageBean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    @RequiredAdminLogin
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
    @RequiredAdminLogin
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
    @RequiredAdminLogin
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
    @RequiredAdminLogin
    @RequiredAuth(auths = {"role:add"})
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
    @RequiredAdminLogin
    @RequiredAuth(auths = {"role:edit"})
    @RequestMapping(value = "/info", method = RequestMethod.PUT)
    @ResponseBody
    public Object editRole(VmRolesDto vmRolesDto) throws Exception {

        return response.putData("role", service.editRole(vmRolesDto));
    }

    /**
     * 删除
     *
     * @return
     */
    @RequiredAdminLogin
    @RequiredAuth(auths = {"role:delete"})
    @RequestMapping(value = "/info", method = RequestMethod.DELETE)
    @ResponseBody
    public Object deleteRole(@RequestBody VmRolesDto vmRolesDto) throws Exception {
        service.deleteRole(vmRolesDto);
        return response;
    }
}
