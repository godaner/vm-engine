package com.vm.dao.mapper;

import com.vm.dao.po.VmMoviesFilesRealation;
import com.vm.dao.po.VmMoviesFilesRealationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VmMoviesFilesRealationMapper {
    long countByExample(VmMoviesFilesRealationExample example);

    int deleteByExample(VmMoviesFilesRealationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(VmMoviesFilesRealation record);

    int insertSelective(VmMoviesFilesRealation record);

    List<VmMoviesFilesRealation> selectByExample(VmMoviesFilesRealationExample example);

    VmMoviesFilesRealation selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") VmMoviesFilesRealation record, @Param("example") VmMoviesFilesRealationExample example);

    int updateByExample(@Param("record") VmMoviesFilesRealation record, @Param("example") VmMoviesFilesRealationExample example);

    int updateByPrimaryKeySelective(VmMoviesFilesRealation record);

    int updateByPrimaryKey(VmMoviesFilesRealation record);
}