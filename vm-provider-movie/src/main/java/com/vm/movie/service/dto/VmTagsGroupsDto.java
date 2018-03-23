package com.vm.movie.service.dto;


import com.vm.base.service.dto.BaseDto;
import com.vm.movie.dao.po.VmTags;

import java.util.List;

/**
 * Created by ZhangKe on 2018/1/10.
 */
public class VmTagsGroupsDto extends BaseDto {

    private String name;

    private List<VmTagsDto> items;

    public List<VmTagsDto> getItems() {
        return items;
    }

    public void setItems(List<VmTagsDto> items) {
        this.items = items;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
