package com.vm.src.service.impl;

import com.google.common.collect.Lists;
import com.vm.base.util.BaseService;
import com.vm.base.util.DateUtil;
import com.vm.base.util.ImageUtil;
import com.vm.base.config.VmConfig;
import com.vm.dao.mapper.VmFilesMapper;
import com.vm.dao.po.BasePo;
import com.vm.dao.po.VmFiles;
import com.vm.src.service.dto.VmFilesDto;
import com.vm.src.service.inf.VmSrcService;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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
    @Autowired
    private VmConfig vmConfig;
    @Override
    public void sendVideoSrc(VmFilesDto vmFilesDto, HttpServletResponse response) {

        Long fileId = vmFilesDto.getFileId();
        InputStream input = null;
        OutputStream output = null;
        try {
            VmFiles file = vmFilesMapper.select(fileId);
            String movieSrcPath = vmConfig.getSrcVideoPath();

            String movieSrcName = null;
            String contentType = null;
            if (file != null) {
                contentType = file.getContentType();
                movieSrcName = file.getFilename();
            }
            File f = new File(movieSrcPath + File.separator + movieSrcName);
            //不存在，返回默认图片
            if (!f.exists()) {
                movieSrcName = vmConfig.getSrcVideoDefault();
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
    public void sendImgSrc(VmFilesDto vmFilesDto, HttpServletResponse response) {
        FileInputStream input = null;
        ServletOutputStream output = null;
        try {
            Long fileId = vmFilesDto.getFileId();
            Integer width = vmFilesDto.getWidth();
            //获取图片id信息
            VmFiles file = vmFilesMapper.select(fileId);
            String imgPath = vmConfig.getSrcImgPath();
            String imgName = null;
            String contentType = null;
            if (file != null) {
                contentType = file.getContentType();
                imgName = file.getFilename();
            }
            //img path name
            String imgPathName = imgPath + File.separator + width + "_" + imgName;;
            if(null == width){
                imgPathName = imgPath + File.separator +  imgName;
            }
            File f = new File(imgPathName);
            //不存在，返回默认图片
            if (!f.exists()) {
                f = new File(imgPath + File.separator + vmConfig.getSrcImgDefault());
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

    @Override
    public Long saveImg(VmFilesDto vmFilesDto) {
        InputStream inputStream = null;
        OutputStream outputStream = null;
        String targetImgName = null;
        String targetHeadImgPathName = null;
        VmFiles vmFiles = null;
        try {
            //file
            MultipartFile imgFile = vmFilesDto.getFile();
            //uuid
            String uuid = uuid();
            //targetPath
            String targetPath = vmConfig.getSrcImgPath();
            //contentType
            String contentType = imgFile.getContentType();
            //originalFilename
            String originalFilename = imgFile.getOriginalFilename();
            //get ext
            String ext = getFileNameExt(originalFilename);
            //get size
            Long size = imgFile.getSize();
            //now
            Integer now = DateUtil.unixTime().intValue();

            targetImgName = uuid + "." + ext;
            targetHeadImgPathName = targetPath + targetImgName;
            //save head Img
            inputStream = imgFile.getInputStream();
            outputStream = new FileOutputStream(targetHeadImgPathName);
            org.apache.commons.io.IOUtils.copy(inputStream, outputStream);


            //写入数据库
            vmFiles = new VmFiles();

            vmFiles.setUpdateTime(now);
            vmFiles.setCreateTime(now);
            vmFiles.setSize(size);
            vmFiles.setStatus(BasePo.Status.NORMAL.getCode());
            vmFiles.setOriginalName(originalFilename);
            vmFiles.setFilename(targetImgName);
            vmFiles.setContentType(contentType);
            vmFilesMapper.insert(vmFiles);

        } catch (Exception e) {
            e.printStackTrace();
            deleteFiles(targetImgName);
        } finally {
            closeStream(inputStream, outputStream);
        }
        return vmFiles.getId();
    }

    @Override
    public Long cutUploadedImgFile(VmFilesDto vmFilesDto) {
        VmFiles vmFiles = vmFilesMapper.select(vmFilesDto.getFileId());

        String filePath = vmConfig.getSrcImgPath();
        String fileName = vmFiles.getFilename();
        String filePathName = filePath + fileName;


        String ext = getFileNameExt(fileName);
        String[] versions = vmFilesDto.getVersions().split(",");
        Lists.newArrayList(versions).stream().parallel().forEach((version) -> {
            String targetFilePath = filePath + version + "_" + fileName;
            try {
                ImageUtil.cutImage(filePathName,
                        targetFilePath,
                        vmFilesDto.getX(),
                        vmFilesDto.getY(),
                        vmFilesDto.getWidth(),
                        vmFilesDto.getHeight(),
                        ext);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        return vmFiles.getId();
    }

}
