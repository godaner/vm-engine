package com.vm.admin.controller;

import com.vm.admin.dao.po.VmAdmins;
import com.vm.admin.dao.qo.VmAdminsQueryBean;
import com.vm.admin.service.inf.VmAdminsService;
import com.vm.base.util.ServiceController;
import com.vm.dao.util.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by ZhangKe on 2018/3/26.
 */
@Controller
@RequestMapping("/movie")
@Scope("prototype")
public class VmAdminsController extends ServiceController<VmAdminsService> {
    /**
     * 获取列表
     *
     * @return
     */
    @RequestMapping(value = "/info/list", method = RequestMethod.GET)
    @ResponseBody
    public Object getAdmins(PageBean page, VmAdminsQueryBean query) throws Exception {

        return response.putData("total", service.getAdmins(page,query)).putData("total", service.getAdminsTotal(page,query));
    }
}
