package com.vm.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * setter不需要static修饰!!!
 * Created by ZhangKe on 2017/12/13.
 */
@PropertySource(value = {"classpath:config/vm.properties"}, encoding = "utf-8")
@Component
public class VmProperties {

    public static String VM_MOVIE_SRC_DEFAULT_NAME;
    public static String VM_MOVIE_IMG_PATH;
    public static String VM_MOVIE_IMG_DEFAULT_NAME;
    public static String VM_MOVIE_SRC_PATH;
    public static String VM_USER_IMG_PATH;
    public static String VM_USER_IMG_DEFAULT_NAME;
    public static String VM_USER_IMG_URL_PREFIX;

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
