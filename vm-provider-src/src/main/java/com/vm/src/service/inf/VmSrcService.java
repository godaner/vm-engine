package com.vm.src.service.inf;

import com.vm.src.service.dto.VmFilesDto;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

/**
 * Created by ZhangKe on 2018/2/3.
 */
public interface VmSrcService {
    void sendVideoSrc(Long fileId, HttpServletResponse response) throws Exception;

    void sendImgSrc(Long fileId, Integer width, HttpServletResponse response) throws Exception;

    void sendImgSrc(Long fileId, HttpServletResponse response) throws Exception;


    Long saveImg(MultipartFile file) throws Exception;

    Long cutUploadedImgFile(VmFilesDto vmFilesDto) throws Exception;

    Long uploadAndCut(VmFilesDto vmFilesDto) throws Exception;

    Long uploadVideo(MultipartFile file) throws Exception;
}
