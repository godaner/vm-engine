package com.vm.controller.frontend;

import com.vm.controller.ServiceController;
import com.vm.service.frontend.VmFrontEndTagsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.lang.reflect.Method;

/**
 * Created by ZhangKe on 2017/12/11.
 */
@Controller
@RequestMapping("/frontend/tags")
public class VmFrontEndTagsController extends ServiceController<VmFrontEndTagsService> {
    /**
     * 获取所有的tags分组及其下面的tags
     * @return
     */
    @RequestMapping(value = "/")
    public Object getTagsGroupsWithTags(){
        response.putData("list",service.getTagsGroupsWithTags());
        return response;
    };
}

