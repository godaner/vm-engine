package com.vm.mapper;

import com.vm.base.bo.VmTagsGroupsWithTagsList;
import com.vm.base.po.VmTagsGroups;
import com.vm.base.po.VmTagsGroupsExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CustomVmTagsGroupsMapper {

    List<VmTagsGroupsWithTagsList> getTagsGroupsWithTags();
}