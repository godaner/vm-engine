package com.vm.movie.controller;

import com.vm.base.util.PageBean;
import com.vm.base.util.ServiceController;
import com.vm.movie.dao.qo.VmMoviesQueryBean;
import com.vm.movie.service.dto.VmMoviesDto;
import com.vm.movie.service.inf.VmMoviesService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * Created by ZhangKe on 2017/12/12.
 */
@Controller
@RequestMapping("/movie")
@Scope("prototype")
public class VmMoviesController extends ServiceController<VmMoviesService> {

    /*********************************用户端****************************/
    /**
     * 获取所有的tags分组及其下面的tags
     *
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public Object getMovies(PageBean page,
                            VmMoviesQueryBean query) throws Exception {

        return response.putData("total", service.getMoviesCount(page, query))
                .putData("list", service.getMovies(page, query));
    }

    /**
     * 获取某个电影的的tags
     *
     * @return
     */
    @RequestMapping(value = "/tag/{movieId}", method = RequestMethod.GET)
    @ResponseBody
    public Object getTagsOfMovie(@PathVariable("movieId") Long movieId) throws Exception {

        return response.putData("list", service.getTagsOfMovie(movieId));
    }

    /**
     * 获取某个电影的信息
     *
     * @param movieId
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/{movieId}", method = RequestMethod.GET)
    @ResponseBody
    public Object getMovie(@PathVariable("movieId") Long movieId) throws Exception {
        return response.putData("movie", service.getMovie(movieId));
    }

    /**
     * 获取电影图片
     *
     * @return
     */
//    @RequestMapping(value = "/img/{fileId}", method = RequestMethod.GET)
//    public void getMovieImg(@PathVariable("fileId") Long fileId, Integer width) throws Exception {
//        service.sendMovieImg(fileId, width, getResponse());
//
//    }

    /**
     * 获取电影资源
     *
     * @return
     */
//    @RequestMapping(value = "/src/{fileId}", method = RequestMethod.GET)
//    public void getMovieSrc(@PathVariable("fileId") Long fileId) throws Exception {
//        service.sendMovieSrc(fileId, getResponse());
//    }

    /**
     * 获取电影相关电影人:包括导演,演员
     *
     * @return
     */
    @RequestMapping(value = "/filmmaker/{movieId}", method = RequestMethod.GET)
    @ResponseBody
    public Object getMovieFilmmakers(@PathVariable("movieId") Long movieId) throws Exception {

        return response.putData("filmmakers", service.getMovieFilmmakers(movieId));
    }

    /**
     * 获取电影版本:例如高清，超清
     *
     * @return
     */
    @RequestMapping(value = "/version/{movieId}", method = RequestMethod.GET)
    @ResponseBody
    public Object getMovieSrcVersions(@PathVariable("movieId") Long movieId) throws Exception {

        return response.putData("versions", service.getMovieSrcVersions(movieId))
                .putData("posterUrl", service.getMoviePosterUrl(movieId));
    }

    /**
     * 获取与标签相关的电影列表
     *
     * @return
     */
    @RequestMapping(value = "/about/tag", method = RequestMethod.GET)
    @ResponseBody
    public Object getAboutTagsMovies(VmMoviesQueryBean query,
                                     PageBean page) throws Exception {
        return response.putData("movies", service.getAboutTagsMovies(page, query));
    }

    /**
     * 获取与电影人相关的电影列表
     *
     * @return
     */
    @RequestMapping(value = "/about/filmmaker", method = RequestMethod.GET)
    @ResponseBody
    public Object getAboutFilmmakersMovies(VmMoviesQueryBean query,
                                           PageBean page) throws Exception {
        return response.putData("movies", service.getAboutFilmmakersMovies(page, query));
    }

    /*********************************管理端****************************/
    /**
     * 获取电影列表
     *
     * @return
     */
    @RequestMapping(value = "/info/list", method = RequestMethod.GET)
    @ResponseBody
    public Object getBackEndMoviesInfo(VmMoviesQueryBean query,
                            PageBean page) throws Exception {
        return response.putData("list", service.getBackendMovies(query,page )).
                putData("total", service.getBackendMoviesTotal(query, page));
    }
    /**
     * 更新电影
     *
     * @return
     */
    @RequestMapping(value = "/info", method = RequestMethod.PUT)
    @ResponseBody
    public Object updateBackEndMoviesInfo(VmMoviesDto vmMoviesDto) throws Exception {
        return response.putData("movie", service.updateBackEndMoviesInfo(vmMoviesDto));
    }
}

