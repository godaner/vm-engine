package com.vm.movie.controller;

import com.vm.base.aop.RequiredAuth;
import com.vm.base.util.ServiceController;
import com.vm.dao.util.BasePo;
import com.vm.dao.util.PageBean;
import com.vm.movie.dao.qo.VmTagGroupsQueryBean;
import com.vm.movie.service.dto.VmTagsGroupsDto;
import com.vm.movie.service.inf.VmTagGroupsService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * Created by ZhangKe on 2017/12/11.
 */
@Controller
@RequestMapping("/tagGroup")
@Scope("prototype")
public class VmTagGroupsController extends ServiceController<VmTagGroupsService> {

    /*********************************用户端****************************/
    /**
     * 获取所有的tags分组及其下面的tags
     *
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public Object getAllTagsGroupsWithTags() throws Exception {
        VmTagGroupsQueryBean query = new VmTagGroupsQueryBean();
        return response.putData("list", service.getAllTagsGroupsWithTags());
    }

    /*********************************管理端****************************/
    @RequiredAuth(auths = {"tagGroup:select"})
    @RequestMapping(value = "/info/list", method = RequestMethod.GET)
    @ResponseBody
    public Object getTagGroups(VmTagGroupsQueryBean query, PageBean page) throws Exception {
        return response.putData("list", service.getTagGroups(query, page))
                .putData("total", service.getTagGroupsTotal(query, page));
    }
    @RequiredAuth(auths = {"tagGroup:edit"})
    @RequestMapping(value = "/info", method = RequestMethod.PUT)
    @ResponseBody
    public Object editTagGroup(VmTagsGroupsDto vmTagsGroupsDto) throws Exception {
        return response.putData("tagGroup", service.editTagGroup(vmTagsGroupsDto));
    }
    @RequiredAuth(auths = {"tagGroup:add"})
    @RequestMapping(value = "/info", method = RequestMethod.POST)
    @ResponseBody
    public Object addTagGroup(VmTagsGroupsDto vmTagsGroupsDto) throws Exception {
        return response.putData("tagGroup", service.addTagGroup(vmTagsGroupsDto));
    }
    @RequiredAuth(auths = {"tagGroup:delete"})
    @RequestMapping(value = "/info", method = RequestMethod.DELETE)
    @ResponseBody
    public Object deleteTagGroups(@RequestBody VmTagsGroupsDto vmTagsGroupsDto) throws Exception {
        service.deleteTagGroups(vmTagsGroupsDto);
        return response;
    }
    /**
     * 获取所有的tags分组及其下面的tags
     *
     * @return
     */
    @RequestMapping(value = "/tag/list", method = RequestMethod.GET)
    @ResponseBody
    public Object getBackendAllTagsGroupsWithTags() throws Exception {
        return response.putData("list", service.getBackendAllTagsGroupsWithTags());
    }
}

