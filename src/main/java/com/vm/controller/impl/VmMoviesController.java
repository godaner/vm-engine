package com.vm.controller.impl;

import com.vm.controller.base.ServiceController;
import com.vm.dao.po.CustomVmMovies;
import com.vm.dao.po.VmFilmmakers;
import com.vm.dao.po.VmMoviesSrcVersion;
import com.vm.dao.po.VmTags;
import com.vm.dao.qo.PageBean;
import com.vm.dao.qo.VmMoviesQueryBean;
import com.vm.service.inf.VmMoviesService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.List;


/**
 * Created by ZhangKe on 2017/12/12.
 */
@Controller
@RequestMapping("/movie")
@Scope("prototype")
public class VmMoviesController extends ServiceController<VmMoviesService> {
    /*********************************前端*********************************/
    /**
     * 获取所有的tags分组及其下面的tags
     *
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public @ResponseBody
    Object getMovies(@Valid PageBean page, BindingResult result, VmMoviesQueryBean query) throws Exception {
        Long total = service.getMoviesCount(page, query);
        List<CustomVmMovies> list = service.getMovies(page, query);
        response.putData("list", list);
        response.putData("total", total);
        return response;
    }

    /**
     * 获取某个电影的的tags
     *
     * @return
     */
    @RequestMapping(value = "/tag/{movieId}", method = RequestMethod.GET)
    public @ResponseBody
    Object getTagsOfMovie(@PathVariable("movieId") Long movieId) throws Exception {

        List<VmTags> list = service.getTagsOfMovie(movieId);
        response.putData("list", list);
        return response;
    }

    /**
     * 获取某个电影的信息
     *
     * @param movieId
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/{movieId}", method = RequestMethod.GET)
    public @ResponseBody
    Object getMovie(@PathVariable("movieId") Long movieId) throws Exception {
        CustomVmMovies movie = service.getMovie(movieId);
        response.putData("movie", movie);
        return response;
    }

    /**
     * 获取电影图片
     *
     * @return
     */
    @RequestMapping(value = "/img/{fileId}", method = RequestMethod.GET)
    public void getMovieImg(@PathVariable("fileId") Long fileId, VmMoviesQueryBean query) throws Exception {

        service.sendMovieImg(fileId, query, getResponse());

    }

    /**
     * 获取电影资源
     *
     * @return
     */
    @RequestMapping(value = "/src/{fileId}", method = RequestMethod.GET)
    public void getMovieSrc(@PathVariable("fileId") Long fileId) throws Exception {
        service.sendMovieSrc(fileId, getResponse());
    }

    /**
     * 获取电影相关电影人:包括导演,演员
     *
     * @return
     */
    @RequestMapping(value = "/filmmaker/{movieId}", method = RequestMethod.GET)
    public @ResponseBody
    Object getMovieFilmmakers(@PathVariable("movieId") Long movieId) throws Exception {
        List<VmFilmmakers> filmmakers = service.getMovieFilmmakers(movieId);
        response.putData("filmmakers", filmmakers);
        return response;
    }

    /**
     * 获取电影版本:例如高清，超清
     *
     * @return
     */
    @RequestMapping(value = "/version/{movieId}", method = RequestMethod.GET)
    public @ResponseBody
    Object getMovieSrcVersions(@PathVariable("movieId") Long movieId) throws Exception {
        List<VmMoviesSrcVersion> versions = service.getMovieSrcVersions(movieId);
        response.putData("versions", versions);
        return response;
    }


    /*********************************后端*********************************/

}

