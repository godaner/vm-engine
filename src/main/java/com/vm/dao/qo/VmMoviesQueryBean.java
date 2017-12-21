package com.vm.dao.qo;

import com.vm.dao.po.VmMovies;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by ZhangKe on 2017/12/12.
 */
public class VmMoviesQueryBean{
    private String keyword;
    private List<Long> tagIds;

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

    @Override
    public String toString() {
        return "VmMoviesQueryBean{" +
                "keyword='" + keyword + '\'' +
                ", tagIds=" + tagIds +
                '}';
    }
}
