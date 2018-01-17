package com.vm.frontend.controller;

import com.vm.base.util.ServiceController;
import com.vm.frontend.service.inf.VmTagsService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


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
    @ResponseBody
    public Object getTagsGroupsWithTags() throws Exception {
        return response.putData("list", service.getTagsGroupsWithTags());
    }


}

