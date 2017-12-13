package com.vm.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Created by ZhangKe on 2017/12/13.
 */
@PropertySource(value = {"classpath:config/vm.properties"},encoding="utf-8")
@Component
public class VmProperties {

    public static String VM_IMG_PATH;
    public static String VM_MOVIE_PATH;



    @Value("${vm.img.path}")
    public void setVmImgPath(String vmImgPath) {
        VM_IMG_PATH = vmImgPath;
    }


    @Value("${vm.movie.path}")
    public void setVmMoviePath(String vmMoviePath) {
        VM_MOVIE_PATH = vmMoviePath;
    }
}
