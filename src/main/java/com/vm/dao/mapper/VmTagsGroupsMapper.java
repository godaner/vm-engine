package com.vm.dao.mapper;

import com.vm.dao.po.CustomVmTagsGroups;
import com.vm.dao.po.VmTagsGroups;
import com.vm.dao.po.VmTagsGroupsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VmTagsGroupsMapper {
    long countByExample(VmTagsGroupsExample example);

    int deleteByExample(VmTagsGroupsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(VmTagsGroups record);

    int insertSelective(VmTagsGroups record);

    List<VmTagsGroups> selectByExample(VmTagsGroupsExample example);

    VmTagsGroups selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") VmTagsGroups record, @Param("example") VmTagsGroupsExample example);

    int updateByExample(@Param("record") VmTagsGroups record, @Param("example") VmTagsGroupsExample example);

    int updateByPrimaryKeySelective(VmTagsGroups record);

    int updateByPrimaryKey(VmTagsGroups record);

}