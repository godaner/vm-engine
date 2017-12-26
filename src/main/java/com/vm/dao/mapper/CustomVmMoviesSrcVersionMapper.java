package com.vm.dao.mapper;

import com.vm.dao.po.VmMoviesSrcVersion;
import com.vm.dao.qo.PageBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by ZhangKe on 2017/12/25.
 */
public interface CustomVmMoviesSrcVersionMapper {

    List<VmMoviesSrcVersion> selectMovieSrcVersionsByMovieId(@Param("movieId") Long movieId);
}
