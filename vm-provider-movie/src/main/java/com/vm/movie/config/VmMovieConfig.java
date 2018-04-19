package com.vm.movie.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * Created by ZhangKe on 2018/2/28.
 */
@Component
@RefreshScope
public class VmMovieConfig {

    @Value("${vm.movie.img.versions}")
    private String movieImgVersions;
    @Value("${vm.movie.poster.versions}")
    private String moviePosterVersions;

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
}
