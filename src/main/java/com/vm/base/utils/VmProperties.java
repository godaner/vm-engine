package com.vm.base.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Created by ZhangKe on 2017/12/13.
 */
@PropertySource(value = {"classpath:config/vm.properties"},encoding="utf-8")
@Component
public class VmProperties {

    @Value("${vm.img.path}")
    public static String VM_IMG_PATH;
    @Value("${vm.movie.path}")
    public static String VM_MOVIE_PATH;
}
