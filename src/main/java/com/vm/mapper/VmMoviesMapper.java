package com.vm.mapper;

import com.vm.base.po.VmMovies;
import com.vm.base.po.VmMoviesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VmMoviesMapper {
    long countByExample(VmMoviesExample example);

    int deleteByExample(VmMoviesExample example);

    int deleteByPrimaryKey(Long id);

    int insert(VmMovies record);

    int insertSelective(VmMovies record);

    List<VmMovies> selectByExample(VmMoviesExample example);

    VmMovies selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") VmMovies record, @Param("example") VmMoviesExample example);

    int updateByExample(@Param("record") VmMovies record, @Param("example") VmMoviesExample example);

    int updateByPrimaryKeySelective(VmMovies record);

    int updateByPrimaryKey(VmMovies record);
}