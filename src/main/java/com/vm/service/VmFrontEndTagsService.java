package com.vm.service;

import com.vm.dao.bo.VmTagsGroupsWithTagsList;

import java.util.List;

/**
 * Created by ZhangKe on 2017/12/11.
 */
public interface VmFrontEndTagsService {
    List<VmTagsGroupsWithTagsList> getTagsGroupsWithTags();
}
