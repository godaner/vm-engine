package com.vm.dao.mapper;

import com.vm.dao.po.custom.CustomVmTagsGroups;

import java.util.List;

public interface CustomVmTagsGroupsMapper {
    List<CustomVmTagsGroups> getTagsGroupsWithTags();
}