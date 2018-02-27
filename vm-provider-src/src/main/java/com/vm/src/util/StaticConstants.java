package com.vm.src.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * Created by ZhangKe on 2018/2/27.
 */
public class StaticConstants {
    public static String VM_SRC_IMG_PATH = "d:/vm/src/img";
    public static String VM_SRC_IMG_DEFAULT = "default.png";
    public static String VM_SRC_VIDEO_PATH = "d:/vm/src/video";
    public static String VM_SRC_VIDEO_DEFAULT = "default.mp4";

//    vm.src.img.path="d:/vm/src/img"
//    vm.src.img.default=default.png
//    vm.src.video.path=d:/vm/src/video
//    vm.src.video.default=default.mp4
}
