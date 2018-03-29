package com.vm.movie.dao.mapper.custom;

import com.vm.dao.util.PageBean;
import com.vm.movie.dao.po.VmMovies;
import com.vm.movie.dao.po.VmTags;
import com.vm.movie.dao.po.custom.CustomVmMovies;
import com.vm.movie.dao.qo.VmFilmmakerQueryBean;
import com.vm.movie.dao.qo.VmMoviesQueryBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustomVmMoviesMapper {

    List<CustomVmMovies> getMovies(@Param("page") PageBean page, @Param("query") VmMoviesQueryBean query);

    Long getMoviesCount(@Param("page") PageBean page, @Param("query") VmMoviesQueryBean query);

    CustomVmMovies getMovie(@Param("movieId") Long movieId);

    List<VmTags> getTagsOfMovie(@Param("movieId") Long movieId);

    List<CustomVmMovies> getAboutTagsMovies(@Param("page") PageBean page, @Param("query") VmMoviesQueryBean query);

    List<CustomVmMovies> getAboutFilmmakersMovies(@Param("page") PageBean page, @Param("query") VmMoviesQueryBean query);

    List<VmMovies> getBackendMovies(@Param("query") VmMoviesQueryBean query, @Param("page") PageBean page);

    Long getBackendMoviesTotal(@Param("query") VmMoviesQueryBean query, @Param("page") PageBean page);

    int emptyDirectorIdByFilmmakerIds(@Param("query") Object query);
}