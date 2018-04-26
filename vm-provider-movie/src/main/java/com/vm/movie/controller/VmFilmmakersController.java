package com.vm.movie.controller;

import com.vm.auth.admin.aop.RequiredAdminLogin;
import com.vm.auth.admin.aop.RequiredAuth;
import com.vm.base.service.dto.UpdateHeadImgInfo;
import com.vm.base.util.ServiceController;
import com.vm.dao.util.PageBean;
import com.vm.movie.dao.qo.VmFilmmakerQueryBean;
import com.vm.movie.service.dto.VmFilmmakersDto;
import com.vm.movie.service.inf.VmFilmmakersService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


/**
 * Created by ZhangKe on 2017/12/26.
 */
@Controller
@RequestMapping("/filmmaker")
@Scope("prototype")
public class VmFilmmakersController extends ServiceController<VmFilmmakersService> {

    /*********************************用户端****************************/
    /**
     * 获取电影图片
     *
     * @return
     */
//    @RequestMapping(value = "/img/{filmmakerId}", method = RequestMethod.GET)
//    public void sendFilmmakerImg(@PathVariable("filmmakerId") Long filmmakerId, Integer width) throws Exception {
//
//        service.sendFilmmakerImg(filmmakerId, width, getResponse());
//
//    }

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
    /**
     * 获取电影相关电影人:包括导演,演员
     *
     * @return
     */
    @RequestMapping(value = "/byMovieId/{movieId}", method = RequestMethod.GET)
    @ResponseBody
    public Object getMovieFilmmakers(@PathVariable("movieId") Long movieId) throws Exception {

        return response.putData("filmmakers", service.getMovieFilmmakers(movieId));
    }

    /*********************************管理端****************************/

    @RequiredAdminLogin
    @RequiredAuth(auths = {"filmmaker:select"})
    @RequestMapping(value = "/info/list", method = RequestMethod.GET)
    @ResponseBody
    public Object getFilmmakers(PageBean page,VmFilmmakerQueryBean query) throws Exception {
        return response.putData("list", service.getFilmmakers(page,query))
                .putData("total", service.getFilmmakersTotal(page,query));
    }
    @RequiredAdminLogin
    @RequiredAuth(auths = {"filmmaker:add"})
    @RequestMapping(value = "/info", method = RequestMethod.POST)
    @ResponseBody
    public Object addFilmmaker(VmFilmmakersDto vmFilmmakersDto) throws Exception {
        return response.putData("filmmaker", service.addFilmmaker(vmFilmmakersDto));
    }
    @RequiredAdminLogin
    @RequiredAuth(auths = {"filmmaker:edit"})
    @RequestMapping(value = "/info", method = RequestMethod.PUT)
    @ResponseBody
    public Object editFilmmaker(VmFilmmakersDto vmFilmmakersDto) throws Exception {
        return response.putData("filmmaker", service.editFilmmaker(vmFilmmakersDto));
    }

    @RequiredAdminLogin
    @RequiredAuth(auths = {"filmmaker:delete"})
    @RequestMapping(value = "/info", method = RequestMethod.DELETE)
    @ResponseBody
    public Object deleteFilmmaker(@RequestBody VmFilmmakersDto vmFilmmakersDto) throws Exception {
        service.deleteFilmmaker(vmFilmmakersDto);
        return response;
    }
    /**
     * 更具已缓存图片更新电影人img<br/>
     *
     * @return
     */
    @RequiredAdminLogin
    @RequiredAuth(auths = {"filmmaker:edit"})
    @RequestMapping(value = "/img", method = RequestMethod.PUT)
    @ResponseBody
    public Object updateImg(UpdateHeadImgInfo updateHeadImgInfo) throws Exception {
        VmFilmmakersDto vmFilmmakersDto = service.updateImg(updateHeadImgInfo);
        return response.putData("filmmaker", vmFilmmakersDto).
                putData("imgUrl", vmFilmmakersDto.getImgUrl());
    }

    @RequiredAdminLogin
    @RequestMapping(value = "/id/list/{movieId}", method = RequestMethod.GET)
    @ResponseBody
    public Object getActorIds(@PathVariable("movieId")Long movieId) throws Exception {
        return response.putData("list", service.getActorIds(movieId));
    }
}

