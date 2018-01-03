package com.vm.frontend.service.inf;

import com.vm.dao.po.CustomVmTagsGroups;
import com.vm.dao.po.VmTags;

import java.util.List;

/**
 * Created by ZhangKe on 2017/12/11.
 */
public interface VmTagsService {
    List<CustomVmTagsGroups> getTagsGroupsWithTags() throws Exception;

    List<VmTags> getTags() throws Exception;

}
