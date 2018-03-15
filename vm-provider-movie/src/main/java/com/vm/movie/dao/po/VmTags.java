package com.vm.movie.dao.po;
import com.vm.dao.util.BasePo;
public class VmTags extends BasePo {

    private String name;

    private Long tagGroupId;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Long getTagGroupId() {
        return tagGroupId;
    }

    public void setTagGroupId(Long tagGroupId) {
        this.tagGroupId = tagGroupId;
    }

}