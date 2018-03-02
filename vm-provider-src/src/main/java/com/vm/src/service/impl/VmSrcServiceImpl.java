package com.vm.src.service.impl;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.vm.base.config.VmConfig;
import com.vm.base.util.BasePo;
import com.vm.base.util.BaseService;
import com.vm.base.util.DateUtil;
import com.vm.base.util.ImageUtil;
import com.vm.src.dao.mapper.VmFilesMapper;
import com.vm.src.dao.po.VmFiles;
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
import java.util.List;

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
            VmFiles file = this.getUsableVmFilesById(fileId);
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
        Long fileId = vmFilesDto.getFileId();
        Integer width = vmFilesDto.getWidth();
        //获取图片id信息
        VmFiles file = this.getUsableVmFilesById(fileId);;
        String imgPath = vmConfig.getSrcImgPath();
        String imgName = null;
        String contentType = "image/png";
        String imgPathName = null;
        if (null == file) {//if db have not this file record
            imgPathName = imgPath + vmConfig.getSrcImgDefault();
            sendFileToHttpResponse(imgPathName, contentType, response);
            return;
        }
        imgName = file.getFilename();
        contentType = file.getContentType();
        if (null == width) {
            imgPathName = imgPath + imgName;
            sendFileToHttpResponse(imgPathName, contentType, response);
            return;
        }
        imgPathName = imgPath + File.separator + width + "_" + imgName;
        sendFileToHttpResponse(imgPathName, contentType, response);

    }

    private void sendFileToHttpResponse(String filePathName, String contentType, HttpServletResponse httpServletResponse) {

        FileInputStream input = null;
        ServletOutputStream output = null;
        try {
            input = new FileInputStream(filePathName);
            output = httpServletResponse.getOutputStream();
            //设置响应的媒体类型
            httpServletResponse.setContentType(contentType); // 设置返回的文件类型
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
            vmFiles.setFileSize(size);
            vmFiles.setStatus(BasePo.Status.NORMAL.getCode());
            vmFiles.setIsDeleted(BasePo.IsDeleted.NO.getCode());
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
        VmFiles vmFiles = this.getUsableVmFilesById(vmFilesDto.getFileId());

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

    @Override
    public void batchUpdate() {
        List<VmFiles> files = Lists.newArrayList();
        for (int i = 0; i < 10; i++) {
            VmFiles f = new VmFiles();
            f.setContentType(i + "");
            f.setFilename("" + i);
            f.setOriginalName("" + i);
            f.setFileSize(Long.valueOf(i));
            f.setCreateTime(DateUtil.unixTime().intValue());
            f.setUpdateTime(DateUtil.unixTime().intValue());
            f.setStatus(BasePo.Status.NORMAL.getCode());
            f.setIsDeleted(BasePo.IsDeleted.NO.getCode());
            files.add(f);
        }
        int ij = vmFilesMapper.batchInsert(files);

        vmFilesMapper.update(412l, ImmutableMap.of(
                "filename", "0"
        ));

        vmFilesMapper.batchUpdate(ImmutableMap.of(
                "filename", "0"
        ), ImmutableMap.of(
                "filename", "110"
        ));

        VmFiles filename = vmFilesMapper.selectOneBy(ImmutableMap.of(
                "filename", "0"
        ));
        ij = vmFilesMapper.deleteBy(ImmutableMap.of(
                "filename", "0"
        ));
        System.out.println(ij);
    }

    @Override
    public Long uploadAndCut(VmFilesDto vmFilesDto) {

        Long fileId = this.saveImg(vmFilesDto);

        vmFilesDto.setFileId(fileId);

        this.cutUploadedImgFile(vmFilesDto);

        return fileId;
    }



    private VmFiles getUsableVmFilesById(Long fileId) {
        VmFiles files = vmFilesMapper.select(fileId);
        return (files != null && BasePo.Status.isNormal(files.getStatus()) && !BasePo.IsDeleted.isDeleted(files.getIsDeleted())) ? files : null;
    }
}
