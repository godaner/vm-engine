package com.vm.movie.dao.mapper.custom;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by ZhangKe on 2018/3/20.
 */
public interface CustomVmMoviesFilmmakersRealationMapper {
    List<Long> selectRealationIdsByfilmmakerIds(@Param("query") Object query);
}
