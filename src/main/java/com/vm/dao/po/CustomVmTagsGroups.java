package com.vm.dao.po;

import com.vm.dao.po.VmTags;
import com.vm.dao.po.VmTagsGroups;

import java.util.List;

/**
 * Created by ZhangKe on 2017/12/11.
 */
public class CustomVmTagsGroups extends VmTagsGroups{
    private List<VmTags> items;

    public List<VmTags> getItems() {
        return items;
    }

    public void setItems(List<VmTags> items) {
        this.items = items;
    }
}
