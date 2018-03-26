package com.vm.movie.dao.po;
import com.vm.dao.util.BasePo;
import com.vm.base.util.ByteConstant;

public class VmMoviesSrcVersion extends BasePo {

    public static final Byte DEFAULT_WEIGHT = (byte)1;

    public static final Integer DEFAULT_PLAYER_SPEED = 0;

    private Byte sharpness;

    private Long movieId;

    private Integer playerSpeed;

    private String srcUrl;

    private Byte weight;


    /**
     * 清晰度
     */
    public enum Sharpness {
        NORMAL(ByteConstant.ONE, "标清"),
        HIGH(ByteConstant.TWO, "高清"),
        SUPER_HIGH(ByteConstant.THREE, "超清");

        Byte code;

        String msg;

        Sharpness(Byte code, String msg) {
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

    public Byte getWeight() {
        return weight;
    }

    public void setWeight(Byte weight) {
        this.weight = weight;
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