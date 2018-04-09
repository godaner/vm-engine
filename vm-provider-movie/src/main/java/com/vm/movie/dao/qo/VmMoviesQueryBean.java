package com.vm.movie.dao.qo;

import com.vm.dao.util.BaseQueryBean;

import java.util.List;

/**
 * Created by ZhangKe on 2017/12/12.
 */
public class VmMoviesQueryBean extends BaseQueryBean{

    private List<Long> tagIds;

    private List<Long> filmmakerIds;

    private Long excludeMovieId;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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

    public List<Long> getTagIds() {
        return tagIds;
    }

    public void setTagIds(List<Long> tagIds) {
        this.tagIds = tagIds;
    }


}
