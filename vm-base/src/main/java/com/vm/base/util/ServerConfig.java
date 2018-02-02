package com.vm.base.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * setter不需要static修饰!!!
 * Created by ZhangKe on 2017/12/13.
 */
@PropertySource(value = {"classpath:config/serverConfig.properties"}, encoding = "utf-8")
@Component
@Configuration
public class ServerConfig {

    public static String VM_MOVIE_SRC_DEFAULT_NAME;
    public static String VM_MOVIE_IMG_PATH;
    public static String VM_MOVIE_IMG_DEFAULT_NAME;
    public static String VM_MOVIE_SRC_PATH;
    public static String VM_USER_IMG_PATH;
    public static String VM_USER_IMG_DEFAULT_NAME;
    public static String VM_USER_IMG_URL_PREFIX;
    public static Integer VM_USER_TEMP_IMG_MAX_SIZE;
    public static String VM_USER_TEMP_IMG_EXTS;
    public static String VM_FILMMAKER_IMG_PATH;
    public static String VM_FILMMAKER_IMG_DEFAULT_NAME;
    public static String VM_USER_IMG_TEMP_PATH;
    public static String VM_USER_IMG_VERSIONS;

    @Value("${vm.user.temp.img.exts}")
    public void setVmUserTempImgExts(String vmUserTempImgExts) {
        VM_USER_TEMP_IMG_EXTS = vmUserTempImgExts;
    }

    @Value("${vm.user.temp.img.max.size}")
    public void setVmUserTempImgMaxSize(Integer vmUserTempImgMaxSize) {
        VM_USER_TEMP_IMG_MAX_SIZE = vmUserTempImgMaxSize;
    }

    @Value("${vm.user.img.versions}")
    public void setVmUserImgVersions(String vmUserImgVersions) {
        VM_USER_IMG_VERSIONS = vmUserImgVersions;
    }

    @Value("${vm.user.img.temp.path}")
    public void setVmUserImgTempPath(String vmUserImgTempPath) {
        VM_USER_IMG_TEMP_PATH = vmUserImgTempPath;
    }

    @Value("${vm.filmmaker.img.path}")
    public void setVmFilmmakerImgPath(String vmFilmmakerImgPath) {
        VM_FILMMAKER_IMG_PATH = vmFilmmakerImgPath;
    }

    @Value("${vm.filmmaker.img.default.name}")
    public void setVmFilmmakerImgDefaultName(String vmFilmmakerImgDefaultName) {
        VM_FILMMAKER_IMG_DEFAULT_NAME = vmFilmmakerImgDefaultName;
    }

    @Value("${vm.user.img.url.prefix}")
    public void setVmUserImgUrlPrefix(String vmUserImgUrlPrefix) {
        VM_USER_IMG_URL_PREFIX = vmUserImgUrlPrefix;
    }


    @Value("${vm.user.img.default.name}")
    public void setVmUserImgDefaultName(String vmUserImgDefaultName) {
        VM_USER_IMG_DEFAULT_NAME = vmUserImgDefaultName;
    }


    @Value("${vm.movie.img.path}")
    public void setVmMovieImgPath(String vmMovieImgPath) {
        VM_MOVIE_IMG_PATH = vmMovieImgPath;
    }

    @Value("${vm.movie.src.default.name}")
    public void setVmMovieSrcDefaultName(String vmMovieSrcDefaultName) {
        VM_MOVIE_SRC_DEFAULT_NAME = vmMovieSrcDefaultName;
    }

    @Value("${vm.movie.img.default.name}")
    public void setVmMovieImgDefaultName(String vmMovieImgDefaultName) {
        VM_MOVIE_IMG_DEFAULT_NAME = vmMovieImgDefaultName;
    }

    @Value("${vm.movie.src.path}")
    public void setVmMovieSrcPath(String vmMovieSrcPath) {
        VM_MOVIE_SRC_PATH = vmMovieSrcPath;
    }

    @Value("${vm.user.img.path}")
    public void setVmUserImgPath(String vmUserImgPath) {
        VM_USER_IMG_PATH = vmUserImgPath;
    }
}
