package com.vm.service.inf;

import com.vm.dao.po.CustomVmTagsGroups;

import java.util.List;

/**
 * Created by ZhangKe on 2017/12/11.
 */
public interface VmTagsService {
    List<CustomVmTagsGroups> getTagsGroupsWithTags();

}
