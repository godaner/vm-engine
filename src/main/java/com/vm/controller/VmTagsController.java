package com.vm.controller;

import com.vm.dao.bo.VmTagsGroupsWithTagsList;
import com.vm.service.VmFrontEndTagsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


/**
 * Created by ZhangKe on 2017/12/11.
 */
@Controller
@RequestMapping("/tag_groups")
public class VmTagsController extends ServiceController<VmFrontEndTagsService> {
    /**
     * 获取所有的tags分组及其下面的tags
     * @return
     */
    @RequestMapping(value = "/all" ,method = RequestMethod.GET)
    public @ResponseBody Object getTagsGroupsWithTags(){
        List<VmTagsGroupsWithTagsList> list = service.getTagsGroupsWithTags();
        response.putData("list",list);
        return response;
    };
}

