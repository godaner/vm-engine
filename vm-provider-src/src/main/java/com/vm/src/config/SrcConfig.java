package com.vm.src.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by ZhangKe on 2018/2/28.
 */
@Component
public class SrcConfig {
    @Value("${vm.src.img.allowSuffix}")
    private String srcImgAllowSuffix;
    @Value("${vm.src.img.url}")
    private String srcImgUrl;
    @Value("${vm.src.img.maxSize}")
    private String srcImgMaxSize;
    @Value("${vm.src.img.path}")
    private String srcImgPath;
    @Value("${vm.src.img.default}")
    private String srcImgDefault;
    @Value("${vm.src.video.path}")
    private String srcVideoPath;
    @Value("${vm.src.video.default}")
    private String srcVideoDefault;
    @Value("${vm.src.video.url}")
    private String srcVideoUrl;

    public String getSrcImgAllowSuffix() {
        return srcImgAllowSuffix;
    }

    public void setSrcImgAllowSuffix(String srcImgAllowSuffix) {
        this.srcImgAllowSuffix = srcImgAllowSuffix;
    }

    public String getSrcImgUrl() {
        return srcImgUrl;
    }

    public void setSrcImgUrl(String srcImgUrl) {
        this.srcImgUrl = srcImgUrl;
    }

    public String getSrcImgMaxSize() {
        return srcImgMaxSize;
    }

    public void setSrcImgMaxSize(String srcImgMaxSize) {
        this.srcImgMaxSize = srcImgMaxSize;
    }

    public String getSrcImgPath() {
        return srcImgPath;
    }

    public void setSrcImgPath(String srcImgPath) {
        this.srcImgPath = srcImgPath;
    }

    public String getSrcImgDefault() {
        return srcImgDefault;
    }

    public void setSrcImgDefault(String srcImgDefault) {
        this.srcImgDefault = srcImgDefault;
    }

    public String getSrcVideoPath() {
        return srcVideoPath;
    }

    public void setSrcVideoPath(String srcVideoPath) {
        this.srcVideoPath = srcVideoPath;
    }

    public String getSrcVideoDefault() {
        return srcVideoDefault;
    }

    public void setSrcVideoDefault(String srcVideoDefault) {
        this.srcVideoDefault = srcVideoDefault;
    }

    public String getSrcVideoUrl() {
        return srcVideoUrl;
    }

    public void setSrcVideoUrl(String srcVideoUrl) {
        this.srcVideoUrl = srcVideoUrl;
    }
}
