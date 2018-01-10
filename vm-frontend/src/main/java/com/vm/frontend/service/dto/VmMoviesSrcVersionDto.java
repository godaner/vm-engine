package com.vm.frontend.service.dto;

/**
 * Created by ZhangKe on 2018/1/10.
 */
public class VmMoviesSrcVersionDto {
    private Long id;

    private Byte sharpness;

    private String srcUrl;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Byte getSharpness() {
        return sharpness;
    }

    public void setSharpness(Byte sharpness) {
        this.sharpness = sharpness;
    }


    public String getSrcUrl() {
        return srcUrl;
    }

    public void setSrcUrl(String srcUrl) {
        this.srcUrl = srcUrl;
    }
}
