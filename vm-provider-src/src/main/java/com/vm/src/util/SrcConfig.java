package com.vm.src.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by ZhangKe on 2018/2/28.
 */
@Component
public class SrcConfig {
    public static String VM_SRC_IMG_ALLOW_SUFFIX;
    public static String VM_SRC_IMG_URL;
    public static String VM_SRC_IMG_MAX_SIZE;
    public static String VM_SRC_IMG_PATH;
    public static String VM_SRC_IMG_DEFAULT;
    public static String VM_SRC_VIDEO_PATH;
    public static String VM_SRC_VIDEO_DEFAULT;
    public static String VM_SRC_VIDEO_URL;


    @Value("${vm.src.img.path}")
    public void setVmSrcImgPath(String vmSrcImgPath) {
        VM_SRC_IMG_PATH = vmSrcImgPath;
    }

    @Value("${vm.src.img.default}")
    public void setVmSrcImgDefault(String vmSrcImgDefault) {
        VM_SRC_IMG_DEFAULT = vmSrcImgDefault;
    }

    @Value("${vm.src.img.url}")
    public static void setVmSrcImgUrl(String vmSrcImgUrl) {
        VM_SRC_IMG_URL = vmSrcImgUrl;
    }

    @Value("${vm.src.img.maxSize}")
    public void setVmSrcImgMaxSize(String vmSrcImgMaxSize) {
        VM_SRC_IMG_MAX_SIZE = vmSrcImgMaxSize;
    }

    @Value("${vm.src.img.allowSuffix}")
    public static void setVmSrcImgAllowSuffix(String vmSrcImgAllowSuffix) {
        VM_SRC_IMG_ALLOW_SUFFIX = vmSrcImgAllowSuffix;
    }

    @Value("${vm.src.video.path}")
    public void setVmSrcVideoPath(String vmSrcVideoPath) {
        VM_SRC_VIDEO_PATH = vmSrcVideoPath;
    }

    @Value("${vm.src.video.default}")
    public void setVmSrcVideoDefault(String vmSrcVideoDefault) {
        VM_SRC_VIDEO_DEFAULT = vmSrcVideoDefault;
    }

    @Value("${vm.src.video.url}")
    public static void setVmSrcVideoUrl(String vmSrcVideoUrl) {
        VM_SRC_VIDEO_URL = vmSrcVideoUrl;
    }
}
