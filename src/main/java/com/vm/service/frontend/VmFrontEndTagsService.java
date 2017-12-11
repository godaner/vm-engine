package com.vm.service.frontend;

import com.vm.base.bo.VmTagsGroupsWithTagsList;
import com.vm.base.po.VmTagsGroups;

import java.util.List;

/**
 * Created by ZhangKe on 2017/12/11.
 */
public interface VmFrontEndTagsService {
    List<VmTagsGroupsWithTagsList> getTagsGroupsWithTags();
}
