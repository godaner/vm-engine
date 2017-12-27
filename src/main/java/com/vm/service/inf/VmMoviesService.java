package com.vm.service.inf;

import com.vm.dao.po.*;
import com.vm.dao.qo.PageBean;
import com.vm.dao.qo.VmMoviesQueryBean;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by ZhangKe on 2017/12/12.
 */
public interface VmMoviesService {
    List<CustomVmMovies> getMovies(PageBean page, VmMoviesQueryBean query) throws Exception;

    Long getMoviesCount(PageBean page, VmMoviesQueryBean query) throws Exception;

    CustomVmMovies getMovie(Long movieId) throws Exception;

    void sendMovieImg(Long fileId, VmMoviesQueryBean query, HttpServletResponse response) throws Exception;

    void sendMovieSrc(Long fileId, HttpServletResponse response) throws Exception;

    List<VmTags> getTagsOfMovie(Long movieId)throws Exception;

    List<VmFilmmakers> getMovieFilmmakers(Long movieId);

    List<VmMoviesSrcVersion> getMovieSrcVersions(Long movieId) throws Exception;

    String getMoviePosterUrl(Long movieId) throws Exception;

    List<VmMovies> getAboutTagsMovies(PageBean page,VmMoviesQueryBean query) throws Exception;

    List<VmMovies> getAboutFilmmakersMovies(PageBean page, VmMoviesQueryBean query);
}
