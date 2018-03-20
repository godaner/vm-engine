package com.vm.movie.service.dto;


import com.vm.movie.dao.po.VmTags;

import java.util.List;

/**
 * Created by ZhangKe on 2018/1/10.
 */
public class VmTagsGroupsDto {
    private Long id;

    private String name;

    private Byte status;

    private Integer createTime;

    private Integer updateTime;

    private List<VmTags> items;

    public List<VmTags> getItems() {
        return items;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Integer getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }

    public Integer getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Integer updateTime) {
        this.updateTime = updateTime;
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
