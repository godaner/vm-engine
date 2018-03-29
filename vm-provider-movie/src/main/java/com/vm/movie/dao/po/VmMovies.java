package com.vm.movie.dao.po;

import com.vm.dao.util.BasePo;

public class VmMovies extends BasePo {

    public static final Float DEFAULT_SCORE = 10F;

    public static final Long DEFAULT_WATCH_NUM = 0l;

    public static final String DEFAULT_POSTER_URL = null;

    public static final String DEFAULT_IMG_URL = null;

    public static final Long DEFAULT_DIRECTOR_ID = null;

    private String name;

    private String alias;

    private String description;

    private Long directorId;

    private Integer releaseTime;

    private Float score;

    private Long watchNum;

    private Integer movieTime;

    private String posterUrl;

    private String imgUrl;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias == null ? null : alias.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Long getDirectorId() {
        return directorId;
    }

    public void setDirectorId(Long directorId) {
        this.directorId = directorId;
    }

    public Integer getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(Integer releaseTime) {
        this.releaseTime = releaseTime;
    }

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }

    public Long getWatchNum() {
        return watchNum;
    }

    public void setWatchNum(Long watchNum) {
        this.watchNum = watchNum;
    }

    public Integer getMovieTime() {
        return movieTime;
    }

    public void setMovieTime(Integer movieTime) {
        this.movieTime = movieTime;
    }

    public String getPosterUrl() {
        return posterUrl;
    }

    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl == null ? null : posterUrl.trim();
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl == null ? null : imgUrl.trim();
    }

}