package com.vm.src.service.inf;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by ZhangKe on 2018/2/3.
 */
public interface VmSrcService {
    void sendVideoSrc(Long fileId, HttpServletResponse response);

    void sendImgSrc(Long fileId, Integer width, HttpServletResponse response);
}
