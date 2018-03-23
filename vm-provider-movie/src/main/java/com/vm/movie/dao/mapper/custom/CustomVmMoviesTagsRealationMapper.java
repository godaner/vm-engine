package com.vm.movie.dao.mapper.custom;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustomVmMoviesTagsRealationMapper {

    List<Long> getTagIdsByMovieId(@Param("query") Object query);

    List<Long> getRealationIdsByTagIds(@Param("query") Object query);
}