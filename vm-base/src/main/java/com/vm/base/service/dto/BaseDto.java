package com.vm.base.service.dto;

import java.io.Serializable;

/**
 * Created by ZhangKe on 2018/3/22.
 */
public class BaseDto implements Serializable {

    private Long id;

    private Byte status;

    private Integer createTime;

    private Integer updateTime;

    private String deletedIds;

    public String getDeletedIds() {
        return deletedIds;
    }

    public void setDeletedIds(String deletedIds) {
        this.deletedIds = deletedIds;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
