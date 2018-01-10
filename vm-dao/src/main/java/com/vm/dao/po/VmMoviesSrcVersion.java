package com.vm.dao.po;

import com.vm.base.utils.ByteConstantVar;

public class VmMoviesSrcVersion extends BasePo {
    private Long id;

    private Byte sharpness;

    private Long movieId;

    private Integer playerSpeed;

    private String srcUrl;

    private Byte status;

    private Integer createTime;

    private Integer updateTime;

    /**
     * 清晰度
     */
    public enum Sharpness {
        NORMAL(ByteConstantVar.ONE,"标清"),
        HIGH(ByteConstantVar.TWO,"高清"),
        SUPER_HIGH(ByteConstantVar.THREE,"超清");

        Byte code;

        String msg;

        Sharpness(Byte code, String msg){
            this.code = code;
            this.msg = msg;
        }

        public Byte getCode() {
            return code;
        }

        public void setCode(Byte code) {
            this.code = code;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

    }
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