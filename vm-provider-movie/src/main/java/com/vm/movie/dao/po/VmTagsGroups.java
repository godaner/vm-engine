package com.vm.movie.dao.po;

import com.vm.dao.util.BasePo;

public class VmTagsGroups extends BasePo {

    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}