package com.vm.src.service.inf;

import com.vm.src.service.dto.VmFilesDto;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by ZhangKe on 2018/2/3.
 */
public interface VmSrcService {
    void sendVideoSrc(VmFilesDto vmFilesDto, HttpServletResponse response);

    void sendImgSrc(VmFilesDto vmFilesDto, HttpServletResponse response);

    Long saveImg(VmFilesDto vmFilesDto);

    Long cutUploadedImgFile(VmFilesDto vmFilesDto);

    void batchUpdate();

    Long uploadAndCut(VmFilesDto vmFilesDto);
}
