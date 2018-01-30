package com.vm.dao.po;

public class VmTagsGroups extends BasePo{

    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}