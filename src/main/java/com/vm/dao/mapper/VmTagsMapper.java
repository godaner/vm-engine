package com.vm.dao.mapper;

import com.vm.dao.po.VmTags;
import com.vm.dao.po.VmTagsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VmTagsMapper {
    long countByExample(VmTagsExample example);

    int deleteByExample(VmTagsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(VmTags record);

    int insertSelective(VmTags record);

    List<VmTags> selectByExample(VmTagsExample example);

    VmTags selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") VmTags record, @Param("example") VmTagsExample example);

    int updateByExample(@Param("record") VmTags record, @Param("example") VmTagsExample example);

    int updateByPrimaryKeySelective(VmTags record);

    int updateByPrimaryKey(VmTags record);
}