package com.vm.movie.service.dto;

import com.vm.base.service.dto.BaseDto;

/**
 * Created by ZhangKe on 2018/1/10.
 */
public class VmMoviesSrcVersionDto extends BaseDto {

    private Byte sharpness;

    private String srcUrl;

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
