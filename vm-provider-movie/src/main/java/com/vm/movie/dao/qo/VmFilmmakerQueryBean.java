package com.vm.movie.dao.qo;

import com.vm.dao.util.BaseQueryBean;

import java.util.List;

/**
 * Created by ZhangKe on 2018/3/19.
 */
public class VmFilmmakerQueryBean extends BaseQueryBean {
    private String name;

    private Long movieId;

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
