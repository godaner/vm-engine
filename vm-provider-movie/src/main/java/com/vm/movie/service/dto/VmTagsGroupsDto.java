package com.vm.movie.service.dto;

import com.vm.dao.po.VmTags;

import java.util.List;

/**
 * Created by ZhangKe on 2018/1/10.
 */
public class VmTagsGroupsDto {
    private Long id;

    private String name;

    private List<VmTags> items;

    public List<VmTags> getItems() {
        return items;
    }

    public void setItems(List<VmTags> items) {
        this.items = items;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
