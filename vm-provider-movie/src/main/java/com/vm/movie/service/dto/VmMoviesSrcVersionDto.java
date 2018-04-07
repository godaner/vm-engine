package com.vm.movie.service.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.vm.base.service.dto.BaseDto;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by ZhangKe on 2018/1/10.
 */
public class VmMoviesSrcVersionDto extends BaseDto {

    private Byte sharpness;

    private String srcUrl;

    private MultipartFile file;
    private Long movieId;

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
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
