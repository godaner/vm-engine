package com.vm.src.service.impl;

import com.vm.base.util.BaseService;
import com.vm.src.util.ServerConfig;
import com.vm.dao.mapper.VmFilesMapper;
import com.vm.dao.po.VmFiles;
import com.vm.src.service.inf.VmSrcService;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.security.MessageDigest;

/**
 * Created by ZhangKe on 2018/2/3.
 */
@Service
public class VmSrcServiceImpl extends BaseService implements VmSrcService {
    @Autowired
    private VmFilesMapper vmFilesMapper;

    @Override
    public void sendVideoSrc(Long fileId, HttpServletResponse response) {

        InputStream input = null;
        OutputStream output = null;
        try {
            VmFiles file = vmFilesMapper.select(fileId);
            String movieSrcPath = ServerConfig.VM_SRC_VIDEO_PATH;

            String movieSrcName = null;
            String contentType = null;
            if (file != null) {
                contentType = file.getContentType();
                movieSrcName = file.getFilename();
            }
            File f = new File(movieSrcPath + File.separator + movieSrcName);
            //不存在，返回默认图片
            if (!f.exists()) {
                movieSrcName = ServerConfig.VM_SRC_VIDEO_DEFAULT;
                f = new File(movieSrcPath + File.separator + movieSrcName);
            }
            input = new FileInputStream(f);
            output = response.getOutputStream();
            //设置响应的媒体类型
            response.setContentType(contentType); // 设置返回的文件类型

//            IOUtils.copy(input, output);

            limitedWriter(response.getOutputStream(), input, 1024 * 1024l, System.currentTimeMillis(), MessageDigest.getInstance("MD5"));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeStream(input, output);
        }
    }

    @Override
    public void sendImgSrc(Long fileId, Integer width, HttpServletResponse response) {
        FileInputStream input = null;
        ServletOutputStream output = null;
        try {
            //获取电影图片id信息
            VmFiles file = vmFilesMapper.select(fileId);
            String movieImgPath = ServerConfig.VM_SRC_IMG_PATH;
            String movieImgName = null;
            String contentType = null;
            if (file != null) {
                contentType = file.getContentType();
                movieImgName = file.getFilename();
            }
            File f = new File(movieImgPath + File.separator + width + "_" + movieImgName);
            //不存在，返回默认图片
            if (!f.exists()) {
                f = new File(movieImgPath + File.separator + ServerConfig.VM_SRC_IMG_DEFAULT);
            }
            input = new FileInputStream(f);
            output = response.getOutputStream();
            //设置响应的媒体类型
// ");
            response.setContentType(contentType); // 设置返回的文件类型
            IOUtils.copy(input, output);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeStream(input, output);
        }
    }
}
