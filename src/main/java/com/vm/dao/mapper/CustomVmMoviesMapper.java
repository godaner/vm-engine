package com.vm.dao.mapper;

import com.vm.dao.po.CustomVmMovies;
import com.vm.dao.po.VmMovies;
import com.vm.dao.po.VmMoviesExample;
import com.vm.dao.po.VmTags;
import com.vm.dao.qo.PageBean;
import com.vm.dao.qo.VmMoviesQueryBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustomVmMoviesMapper {

    List<CustomVmMovies> getMovies(@Param("page") PageBean page, @Param("query") VmMoviesQueryBean query);

    Long getMoviesCount(@Param("page") PageBean page, @Param("query") VmMoviesQueryBean query);

    CustomVmMovies getMovie(@Param("movieId") Long movieId);

    List<VmTags> getTagsOfMovie(@Param("movieId") Long movieId);

    List<VmMovies> getAboutTagsMovies(@Param("page") PageBean page, @Param("query") VmMoviesQueryBean query);

    List<VmMovies> getAboutFilmmakersMovies(@Param("page") PageBean page, @Param("query") VmMoviesQueryBean query);
}