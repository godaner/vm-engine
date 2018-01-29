package com.vm.movie.controller;

import com.vm.base.util.ServiceController;
import com.vm.movie.service.inf.FilmmakersService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


/**
 * Created by ZhangKe on 2017/12/26.
 */
@Controller
@RequestMapping("/filmmaker")
@Scope("prototype")
public class VmFilmmakersController extends ServiceController<FilmmakersService> {

    /**
     * 获取电影图片
     *
     * @return
     */
    @RequestMapping(value = "/img/{filmmakerId}", method = RequestMethod.GET)
    public void sendFilmmakerImg(@PathVariable("filmmakerId") Long filmmakerId, Integer width) throws Exception {

        service.sendFilmmakerImg(filmmakerId, width, getResponse());

    }

    /**
     * 获取电影人基本信息
     *
     * @param filmmakerId
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/{filmmakerId}", method = RequestMethod.GET)
    @ResponseBody
    public Object getFilmmakerBasicInfo(@PathVariable("filmmakerId") Long filmmakerId) throws Exception {
        return response.putData("filmmaker", service.getFilmmakerBasicInfo(filmmakerId));
    }


}

