package com.vm.movie.controller;

import com.vm.base.service.dto.UpdateHeadImgInfo;
import com.vm.base.util.ServiceController;
import com.vm.dao.util.PageBean;
import com.vm.movie.dao.qo.VmMoviesQueryBean;
import com.vm.movie.service.dto.VmMoviesDto;
import com.vm.movie.service.dto.VmMoviesSrcVersionDto;
import com.vm.movie.service.inf.VmMovieSrcVersionsService;
import com.vm.movie.service.inf.VmMoviesService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * Created by ZhangKe on 2018/3/24.
 */
@Controller
@RequestMapping("/movie/version")
@Scope("prototype")
public class VmMovieSrcVersionsController extends ServiceController<VmMovieSrcVersionsService> {

    /*********************************用户端****************************/
    /**
     * 获取电影版本:例如高清，超清
     *
     * @return
     */
    @RequestMapping(value = "/{movieId}", method = RequestMethod.GET)
    @ResponseBody
    public Object getMovieSrcVersions(@PathVariable("movieId") Long movieId) throws Exception {

        return response.putData("versions", service.getMovieSrcVersions(movieId));
    }

    /*********************************管理端****************************/
    /**
     * 保存电影版本:例如高清，超清
     * @param vmMoviesSrcVersionDto
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/video", method = RequestMethod.POST)
    @ResponseBody
    public Object uploadVideo(VmMoviesSrcVersionDto vmMoviesSrcVersionDto) throws Exception {
        return response.putData("video",service.uploadVideo(vmMoviesSrcVersionDto));
    }
    /**
     * 通过电影id获取所有的电影版本
     * @param movieId
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/info/list/ByMovieId/{movieId}", method = RequestMethod.GET)
    @ResponseBody
    public Object getAllVersionsByMovieId(@PathVariable("movieId") Long movieId) throws Exception {
        ;
        return response.putData("list",service.getAllVersionsByMovieId(movieId));
    }

}

