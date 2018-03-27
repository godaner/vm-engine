package com.vm.admin.controller;

import com.vm.admin.service.dto.VmMenusDto;
import com.vm.admin.service.inf.VmMenusService;
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
@RequestMapping("/admin/menu")
@Scope("prototype")
public class VmMenusController extends ServiceController<VmMenusService> {

    /**
     * 获取列表
     *
     * @return
     */
    @RequestMapping(value = "/tree/byAdminId/{adminId}", method = RequestMethod.GET)
    @ResponseBody
    public Object getMenusTreeByAdminId(@PathVariable("adminId") Long adminId) throws Exception {

        return response.putData("tree", service.getMenusTreeByAdminId(adminId)).setMsg("获取菜单成功");
    }
    /**
     * 获取所有列表
     *
     * @return
     */
    @RequestMapping(value = "/tree/all", method = RequestMethod.GET)
    @ResponseBody
    public Object getAllMenusTree(VmMenusDto vmMenusDto) throws Exception {

        return response.putData("tree", service.getAllMenusTree(vmMenusDto));
    }
    /**
     * 获取列表
     *
     * @return
     */
    @RequestMapping(value = "/id/list/byRoleId/{roleId}", method = RequestMethod.GET)
    @ResponseBody
    public Object getMenuIdsByRoleId(@PathVariable("roleId") Long roleId) throws Exception {

        return response.putData("tree", service.getMenuIdsByRoleId(roleId));
    }

}
