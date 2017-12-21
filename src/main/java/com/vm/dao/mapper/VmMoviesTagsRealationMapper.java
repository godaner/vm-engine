package com.vm.dao.mapper;

import com.vm.dao.po.VmMoviesTagsRealation;
import com.vm.dao.po.VmMoviesTagsRealationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VmMoviesTagsRealationMapper {
    long countByExample(VmMoviesTagsRealationExample example);

    int deleteByExample(VmMoviesTagsRealationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(VmMoviesTagsRealation record);

    int insertSelective(VmMoviesTagsRealation record);

    List<VmMoviesTagsRealation> selectByExample(VmMoviesTagsRealationExample example);

    VmMoviesTagsRealation selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") VmMoviesTagsRealation record, @Param("example") VmMoviesTagsRealationExample example);

    int updateByExample(@Param("record") VmMoviesTagsRealation record, @Param("example") VmMoviesTagsRealationExample example);

    int updateByPrimaryKeySelective(VmMoviesTagsRealation record);

    int updateByPrimaryKey(VmMoviesTagsRealation record);
}