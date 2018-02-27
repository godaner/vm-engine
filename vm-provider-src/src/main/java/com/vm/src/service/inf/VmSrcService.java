package com.vm.src.service.inf;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by ZhangKe on 2018/2/3.
 */
public interface VmSrcService {
    void sendVideoSrc(Long fileId, HttpServletResponse response);

    void sendImgSrc(Long fileId, Integer width, HttpServletResponse response);

    Long saveImg(MultipartFile headImg);
}
