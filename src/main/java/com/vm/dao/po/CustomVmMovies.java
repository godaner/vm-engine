package com.vm.dao.po;

import java.util.List;

/**
 * Created by ZhangKe on 2017/12/12.
 */
public class CustomVmMovies extends BasePo {
    private Long id;

    private String name;

    private String alias;

    private String description;

    private Long directorId;

    private Integer releaseTime;

    private Float score;

    private Long watchNum;

    private Integer movieTime;

    private String srcUrl;

    private String imgUrl;

    private Byte status;

    private Integer createTime;

    private Integer updateTime;

    //附加属性
    private List<VmFilmmakers> actors;
    private VmFilmmakers director;
    private List<VmTags> tags;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getSrcUrl() {
        return srcUrl;
    }

    public void setSrcUrl(String srcUrl) {
        this.srcUrl = srcUrl;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
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



    public List<VmTags> getTags() {
        return tags;
    }

    public void setTags(List<VmTags> tags) {
        this.tags = tags;
    }

    public List<VmFilmmakers> getActors() {
        return actors;
    }

    public void setActors(List<VmFilmmakers> actors) {
        this.actors = actors;
    }

    public VmFilmmakers getDirector() {
        return director;
    }

    public void setDirector(VmFilmmakers director) {
        this.director = director;
    }
}
