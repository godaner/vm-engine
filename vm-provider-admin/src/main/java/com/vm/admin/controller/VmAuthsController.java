package com.vm.admin.controller;

import com.vm.admin.dao.qo.VmRolesQueryBean;
import com.vm.admin.service.dto.VmRolesDto;
import com.vm.admin.service.impl.VmAuthsServiceImpl;
import com.vm.admin.service.inf.VmAuthsService;
import com.vm.admin.service.inf.VmRolesService;
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

}
