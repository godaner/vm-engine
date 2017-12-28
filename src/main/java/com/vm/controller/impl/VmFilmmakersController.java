package com.vm.controller.impl;

import com.vm.controller.base.ServiceController;
import com.vm.dao.po.VmFilmmakers;
import com.vm.dao.qo.VmFilmmakersQueryBean;
import com.vm.service.inf.FilmmakersService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * Created by ZhangKe on 2017/12/26.
 */
@Controller
@RequestMapping("/filmmaker")
@Scope("prototype")
public class VmFilmmakersController extends ServiceController<FilmmakersService> {
    /*********************************前端*********************************/
    /**
     * 获取电影图片
     *
     * @return
     */
    @RequestMapping(value = "/img/{filmmakerId}", method = RequestMethod.GET)
    public void sendFilmmakerImg(@PathVariable("filmmakerId") Long filmmakerId, VmFilmmakersQueryBean query) throws Exception {

        service.sendFilmmakerImg(filmmakerId, query, getResponse());

    }

    /**
     * 获取电影人基本信息
     * @param filmmakerId
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/{filmmakerId}", method = RequestMethod.GET)
    public @ResponseBody
    Object getFilmmakerBasicInfo(@PathVariable("filmmakerId") Long filmmakerId) throws Exception {
        VmFilmmakers filmmaker = service.getFilmmakerBasicInfo(filmmakerId);
        response.putData("filmmaker", filmmaker);
        return response;
    }

    /*********************************后端*********************************/

}

