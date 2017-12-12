package com.vm.dao.mapper;

import com.vm.dao.bo.VmTagsGroupsWithTagsList;

import java.util.List;

public interface CustomVmTagsGroupsMapper {

    List<VmTagsGroupsWithTagsList> getTagsGroupsWithTags();
}