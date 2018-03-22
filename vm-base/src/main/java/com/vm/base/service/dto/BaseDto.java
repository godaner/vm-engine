package com.vm.base.service.dto;

import org.assertj.core.util.Lists;

import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Created by ZhangKe on 2018/3/22.
 */
public class BaseDto {

    private List<Long> deletedIdsList;

    public List<Long> getDeletedIdsList() {
        if (deletedIdsList != null) {
            return deletedIdsList;
        }
        deletedIdsList = Lists.newArrayList(getDeletedIds().split(",")).stream().parallel().map(idStr -> {
            return Long.valueOf(idStr);
        }).collect(toList());
        return deletedIdsList;
    }

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
