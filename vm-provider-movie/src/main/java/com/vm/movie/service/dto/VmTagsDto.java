package com.vm.movie.service.dto;

import com.vm.base.service.dto.BaseDto;

/**
 * Created by ZhangKe on 2018/1/10.
 */
public class VmTagsDto extends BaseDto {

    private String name;

    private Long tagGroupId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getTagGroupId() {
        return tagGroupId;
    }

    public void setTagGroupId(Long tagGroupId) {
        this.tagGroupId = tagGroupId;
    }
}
