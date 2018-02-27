package com.vm.src.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * setter不需要static修饰!!!
 * Created by ZhangKe on 2017/12/13.
 */
@Component
public class ProviderSrcServerConfig {

    public static String VM_SRC_IMG_PATH;
    public static String VM_SRC_IMG_DEFAULT;
    public static String VM_SRC_VIDEO_PATH;
    public static String VM_SRC_VIDEO_DEFAULT;


    @Value("${vm.src.img.path}")
    public void setVmSrcImgPath(String vmSrcImgPath) {
        VM_SRC_IMG_PATH = vmSrcImgPath;
    }

    @Value("${vm.src.img.default}")
    public void setVmSrcImgDefault(String vmSrcImgDefault) {
        VM_SRC_IMG_DEFAULT = vmSrcImgDefault;
    }

    @Value("${vm.src.video.path}")
    public void setVmSrcVideoPath(String vmSrcVideoPath) {
        VM_SRC_VIDEO_PATH = vmSrcVideoPath;
    }

    @Value("${vm.src.video.default}")
    public void setVmSrcVideoDefault(String vmSrcVideoDefault) {
        VM_SRC_VIDEO_DEFAULT = vmSrcVideoDefault;
    }
}
