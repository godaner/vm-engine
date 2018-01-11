package com.vm.dao.mapper.custom;

import com.vm.dao.po.VmMoviesSrcVersion;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by ZhangKe on 2017/12/25.
 */
public interface CustomVmMoviesSrcVersionMapper {

    List<VmMoviesSrcVersion> selectMovieSrcVersionsByMovieId(@Param("movieId") Long movieId);
}
