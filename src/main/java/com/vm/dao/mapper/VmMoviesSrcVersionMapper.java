package com.vm.dao.mapper;

import com.vm.dao.po.VmMoviesSrcVersion;
import com.vm.dao.po.VmMoviesSrcVersionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VmMoviesSrcVersionMapper {
    long countByExample(VmMoviesSrcVersionExample example);

    int deleteByExample(VmMoviesSrcVersionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(VmMoviesSrcVersion record);

    int insertSelective(VmMoviesSrcVersion record);

    List<VmMoviesSrcVersion> selectByExample(VmMoviesSrcVersionExample example);

    VmMoviesSrcVersion selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") VmMoviesSrcVersion record, @Param("example") VmMoviesSrcVersionExample example);

    int updateByExample(@Param("record") VmMoviesSrcVersion record, @Param("example") VmMoviesSrcVersionExample example);

    int updateByPrimaryKeySelective(VmMoviesSrcVersion record);

    int updateByPrimaryKey(VmMoviesSrcVersion record);
}