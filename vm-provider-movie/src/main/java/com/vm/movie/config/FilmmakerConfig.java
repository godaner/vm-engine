package com.vm.movie.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by ZhangKe on 2018/2/28.
 */
@Component
public class FilmmakerConfig {

    @Value("${vm.filmmaker.img.versions}")
    private String filmmakerImgVersions;

    public String getFilmmakerImgVersions() {
        return filmmakerImgVersions;
    }

    public void setFilmmakerImgVersions(String filmmakerImgVersions) {
        this.filmmakerImgVersions = filmmakerImgVersions;
    }
}
