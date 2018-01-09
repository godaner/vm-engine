package com.vm.frontend.controller;

import com.vm.base.utils.ServiceController;
import com.vm.dao.po.CustomVmTagsGroups;
import com.vm.frontend.service.inf.VmTagsService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


/**
 * Created by ZhangKe on 2017/12/11.
 */
@Controller
@RequestMapping("/tagGroup")
@Scope("prototype")
public class VmTagGroupsController extends ServiceController<VmTagsService> {

    /**
     * 获取所有的tags分组及其下面的tags
     *
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public @ResponseBody
    Object getTagsGroupsWithTags()  throws Exception {
        List<CustomVmTagsGroups> list = service.getTagsGroupsWithTags();
        response.putData("list", list);
        return response;
    }



}

