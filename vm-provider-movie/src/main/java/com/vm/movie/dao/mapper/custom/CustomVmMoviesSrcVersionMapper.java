package com.vm.movie.dao.mapper.custom;

import com.google.common.collect.ImmutableMap;
import com.vm.movie.dao.po.VmMoviesSrcVersion;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by ZhangKe on 2017/12/25.
 */
public interface CustomVmMoviesSrcVersionMapper {
    List<Long> getMovieSrcVersionIdsByMovieIds(@Param("query") Object query);

//    List<VmMoviesSrcVersion> selectMovieSrcVersionsByMovieId(@Param("movieId") Long movieId);
}
