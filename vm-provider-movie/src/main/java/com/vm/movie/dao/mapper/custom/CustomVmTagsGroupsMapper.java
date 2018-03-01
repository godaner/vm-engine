package com.vm.movie.dao.mapper.custom;

import com.vm.movie.dao.po.custom.CustomVmTagsGroups;

import java.util.List;

public interface CustomVmTagsGroupsMapper {
    List<CustomVmTagsGroups> getTagsGroupsWithTags();
}