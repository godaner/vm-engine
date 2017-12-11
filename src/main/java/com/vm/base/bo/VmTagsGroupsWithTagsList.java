package com.vm.base.bo;

import com.vm.base.po.VmTags;
import com.vm.base.po.VmTagsGroups;

import java.util.List;

/**
 * Created by ZhangKe on 2017/12/11.
 */
public class VmTagsGroupsWithTagsList extends VmTagsGroups{
    private List<VmTags> items;

    public List<VmTags> getItems() {
        return items;
    }

    public void setItems(List<VmTags> items) {
        this.items = items;
    }
}
