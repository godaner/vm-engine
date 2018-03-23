package com.vm.movie.controller;

import com.vm.base.util.ServiceController;
import com.vm.movie.service.dto.VmTagsDto;
import com.vm.movie.service.inf.VmTagsService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


/**
 * Created by ZhangKe on 2017/12/20.
 */
@Controller
@RequestMapping("/tag")
@Scope("prototype")
public class VmTagsController extends ServiceController<VmTagsService> {

    /*********************************用户端****************************/
    /**
     * 获取所有的tags
     *
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public Object getTags() throws Exception {
        return response.putData("list", service.getTags());
    }

    /*********************************管理端****************************/

    @RequestMapping(value = "/info/{tagGroupId}", method = RequestMethod.GET)
    @ResponseBody
    public Object getTagsByTagGroupId(@PathVariable("tagGroupId") Long tagGroupId) throws Exception {
        return response.putData("list", service.getTagsByTagGroupId(tagGroupId));
    }

    @RequestMapping(value = "/info", method = RequestMethod.POST)
    @ResponseBody
    public Object addTag(VmTagsDto vmTagsDto) throws Exception {
        return response.putData("tag", service.addTag(vmTagsDto));
    }

    @RequestMapping(value = "/info", method = RequestMethod.PUT)
    @ResponseBody
    public Object editTag(VmTagsDto vmTagsDto) throws Exception {
        return response.putData("tag", service.editTag(vmTagsDto));
    }

    @RequestMapping(value = "/info", method = RequestMethod.DELETE)
    @ResponseBody
    public Object deleteTags(@RequestBody VmTagsDto vmTagsDto) throws Exception {
        service.deleteTags(vmTagsDto);
        return response;
    }
    @RequestMapping(value = "/id/list/{movieId}", method = RequestMethod.GET)
    @ResponseBody
    public Object getTagIdsByMovieId(@PathVariable("movieId")Long movieId) throws Exception {
        return response.putData("list",service.getTagIdsByMovieId(movieId));
    }
}

