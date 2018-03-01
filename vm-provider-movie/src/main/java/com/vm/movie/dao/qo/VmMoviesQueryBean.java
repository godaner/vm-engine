package com.vm.movie.dao.qo;

import com.vm.base.util.BaseQueryBean;

import java.util.List;

/**
 * Created by ZhangKe on 2017/12/12.
 */
public class VmMoviesQueryBean extends BaseQueryBean{
    private String keyword;

    private List<Long> tagIds;

    private List<Long> filmmakerIds;

    private Long excludeMovieId;

    /**
     * 非前台数据
     */
    private Integer tagIdsLength;


    public Long getExcludeMovieId() {
        return excludeMovieId;
    }

    public void setExcludeMovieId(Long excludeMovieId) {
        this.excludeMovieId = excludeMovieId;
    }

    public List<Long> getFilmmakerIds() {
        return filmmakerIds;
    }

    public void setFilmmakerIds(List<Long> filmmakerIds) {
        this.filmmakerIds = filmmakerIds;
    }

    public Integer getTagIdsLength() {
        return tagIdsLength;
    }

    public void setTagIdsLength(Integer tagIdsLength) {
        this.tagIdsLength = tagIdsLength;
    }

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
                ", filmmakerIds=" + filmmakerIds +
                ", excludeMovieId=" + excludeMovieId +
                ", tagIdsLength=" + tagIdsLength +
                '}';
    }
}
