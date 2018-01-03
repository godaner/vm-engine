package com.vm.dao.po;

public class VmMoviesSrcVersion {
    private Long id;

    private Byte status;

    private Integer createTime;

    private Integer updateTime;

    private Byte sharpness;

    private Long movieId;

    private Integer playerSpeed;

    private String srcUrl;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Byte getSharpness() {
        return sharpness;
    }

    public void setSharpness(Byte sharpness) {
        this.sharpness = sharpness;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public Integer getPlayerSpeed() {
        return playerSpeed;
    }

    public void setPlayerSpeed(Integer playerSpeed) {
        this.playerSpeed = playerSpeed;
    }

    public String getSrcUrl() {
        return srcUrl;
    }

    public void setSrcUrl(String srcUrl) {
        this.srcUrl = srcUrl == null ? null : srcUrl.trim();
    }
}