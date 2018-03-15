package com.vm.movie.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by ZhangKe on 2018/2/28.
 */
@Component
public class MovieConfig {

    @Value("${vm.movie.img.versions}")
    private String movieImgVersions;

    public String getMovieImgVersions() {
        return movieImgVersions;
    }

    public void setMovieImgVersions(String movieImgVersions) {
        this.movieImgVersions = movieImgVersions;
    }
}
