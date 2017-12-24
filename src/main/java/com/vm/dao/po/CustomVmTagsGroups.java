package com.vm.dao.po;

import java.util.List;

/**
 * Created by ZhangKe on 2017/12/11.
 */
public class CustomVmTagsGroups extends BasePo {
    private Long id;

    private String name;

    private Byte status;

    private Integer createTime;

    private Integer updateTime;

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
}
