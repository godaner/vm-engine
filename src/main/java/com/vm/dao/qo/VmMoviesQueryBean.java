package com.vm.dao.qo;

import com.vm.dao.po.VmMovies;

import java.util.List;

/**
 * Created by ZhangKe on 2017/12/12.
 */
public class VmMoviesQueryBean{
    private String keyword;
    private List<Long> tagIds;
    private List<Long> tagGroupIds;

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public List<Long> getTagIds() {
        return tagIds;
    }

    public void setTagIds(List<Long> tagIds) {
        this.tagIds = tagIds;
    }

    public List<Long> getTagGroupIds() {
        return tagGroupIds;
    }

    public void setTagGroupIds(List<Long> tagGroupIds) {
        this.tagGroupIds = tagGroupIds;
    }
}
