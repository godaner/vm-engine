package com.vm.base.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * Created by ZhangKe on 2018/4/24.
 */
@Component
@RefreshScope
public class VmBaseConfig {

    @Value("${vm.user.session.lifetime}")
    private Long userSessionLifetime;
    @Value("${vm.user.img.versions}")
    private String userImgVersions;
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
    @Value("${vm.movie.img.versions}")
    private String movieImgVersions;
    @Value("${vm.movie.poster.versions}")
    private String moviePosterVersions;
    @Value("${vm.admin.session.lifetime}")
    private Long adminSessionLifetime;

    public Long getAdminSessionLifetime() {
        return adminSessionLifetime;
    }

    public void setAdminSessionLifetime(Long adminSessionLifetime) {


        this.adminSessionLifetime = adminSessionLifetime;
    }

    public String getMoviePosterVersions() {
        return moviePosterVersions;
    }

    public void setMoviePosterVersions(String moviePosterVersions) {
        this.moviePosterVersions = moviePosterVersions;
    }

    public String getMovieImgVersions() {
        return movieImgVersions;
    }

    public void setMovieImgVersions(String movieImgVersions) {
        this.movieImgVersions = movieImgVersions;
    }

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

    public String getUserImgVersions() {
        return userImgVersions;
    }

    public void setUserImgVersions(String userImgVersions) {
        this.userImgVersions = userImgVersions;
    }

    public Long getUserSessionLifetime() {
        return userSessionLifetime;
    }


    public void setUserSessionLifetime(Long userSessionLifetime) {

        this.userSessionLifetime = userSessionLifetime;
    }
}
