package com.vm.dao.mapper;

import com.vm.dao.bo.VmTagsGroupsWithTagsList;

import java.util.List;

/**
 * Created by ZhangKe on 2017/12/12.
 */
public interface CustomVmTagsGroupsMapper {
    List<VmTagsGroupsWithTagsList> getTagsGroupsWithTags();
}
