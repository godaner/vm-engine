package com.vm.src.service.impl;

import com.google.common.collect.Lists;
import com.vm.base.util.BaseService;
import com.vm.base.util.DateUtil;
import com.vm.base.util.IOUtil;
import com.vm.base.util.ImageUtil;
import com.vm.dao.util.BasePo;
import com.vm.dao.util.QuickSelectOne;
import com.vm.src.config.SrcConfig;
import com.vm.src.dao.mapper.VmFilesMapper;
import com.vm.src.dao.po.VmFiles;
import com.vm.src.service.dto.VmFilesDto;
import com.vm.src.service.inf.VmSrcService;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by ZhangKe on 2018/2/3.
 */
@Service
public class VmSrcServiceImpl extends BaseService implements VmSrcService {
    private Logger logger = LoggerFactory.getLogger(VmSrcServiceImpl.class);
    @Autowired
    private VmFilesMapper vmFilesMapper;
    @Autowired
    private SrcConfig srcConfig;

    @Override
    public void sendVideoSrc(Long fileId, HttpServletResponse response) throws IOException, NoSuchAlgorithmException {

        logger.info("sendVideoSrc fileId is : {} !", fileId);

        InputStream input = null;
        OutputStream output = null;
        try {
            VmFiles file = this.getUsableVmFilesById(fileId);
            String movieSrcPath = srcConfig.getSrcVideoPath();

            String movieSrcName = null;
            String contentType = null;
            if (file != null) {
                contentType = file.getContentType();
                movieSrcName = file.getFilename();
            }
            File f = new File(movieSrcPath + File.separator + movieSrcName);
            //不存在，返回默认图片
            if (!f.exists()) {
                movieSrcName = srcConfig.getSrcVideoDefault();
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
            throw e;
        } finally {
            IOUtil.closeStream(input, output);
        }
    }

    @Override
    public void sendImgSrc(Long fileId, Integer width, HttpServletResponse response) throws IOException {
        logger.info("sendImgSrc fileId is : {} , width is : {} !", fileId, width);
        //获取图片id信息
        VmFiles file = this.getUsableVmFilesById(fileId);
        ;
        String imgPath = srcConfig.getSrcImgPath();
        String imgName = null;
        String contentType = "image/png";
        String imgPathName = null;
        if (null == file) {//if db have not this file record
            imgPathName = imgPath + srcConfig.getSrcImgDefault();
            sendFileToHttpResponse(imgPathName, contentType, response);
            return;
        }
        imgName = file.getFilename();
        contentType = file.getContentType();

        imgPathName = imgPath + File.separator + width + "_" + imgName;
        logger.info("sendImgSrc file is : {} !", imgPathName);
        sendFileToHttpResponse(imgPathName, contentType, response);

    }

    @Override
    public void sendImgSrc(Long fileId, HttpServletResponse response) throws Exception {
        logger.info("sendImgSrc fileId  is : {} !", fileId);
        //获取图片id信息
        VmFiles file = this.getUsableVmFilesById(fileId);
        ;
        String imgPath = srcConfig.getSrcImgPath();
        String imgName = null;
        String contentType = "image/png";
        String imgPathName = null;
        if (null == file) {//if db have not this file record
            imgPathName = imgPath + srcConfig.getSrcImgDefault();
            sendFileToHttpResponse(imgPathName, contentType, response);
            return;
        }
        imgName = file.getFilename();
        contentType = file.getContentType();

        imgPathName = imgPath + File.separator + imgName;

        logger.info("sendImgSrc file is : {} !", imgPathName);
        sendFileToHttpResponse(imgPathName, contentType, response);
    }

    private void sendFileToHttpResponse(String filePathName, String contentType, HttpServletResponse httpServletResponse) throws IOException {

        FileInputStream input = null;
        ServletOutputStream output = null;
        try {
            input = new FileInputStream(filePathName);
            output = httpServletResponse.getOutputStream();
            //设置响应的媒体类型
            httpServletResponse.setContentType(contentType); // 设置返回的文件类型
            IOUtils.copy(input, output);

            logger.error("sendImgSrc#sendFileToHttpResponse send file : {} success ！", filePathName);
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        } finally {
            IOUtil.closeStream(input, output);
        }

    }

    @Override
    public Long saveImg(MultipartFile file) throws Exception {

        logger.info("saveImg file is : {} !", file.getOriginalFilename());

        InputStream inputStream = null;
        OutputStream outputStream = null;
        String targetFileName = null;
        String targetPathName = null;
        VmFiles vmFiles = null;
        try {
            //file
            MultipartFile imgFile = file;
            //uuid
            String uuid = uuid();
            //targetPath
            String targetPath = srcConfig.getSrcImgPath();
            //contentType
            String contentType = imgFile.getContentType();
            //originalFilename
            String originalFilename = imgFile.getOriginalFilename();
            //get ext
            String ext = IOUtil.getFileNameExt(originalFilename);
            //get size
            Long size = imgFile.getSize();
            //now
            Integer now = DateUtil.unixTime().intValue();

            targetFileName = uuid + "." + ext;
            targetPathName = targetPath + targetFileName;
            //save head Img
            inputStream = imgFile.getInputStream();
            outputStream = new FileOutputStream(targetPathName);
            //compress img
            ImageUtil.resize(inputStream,outputStream,600,-1);
//            org.apache.commons.io.IOUtils.copy(inputStream, outputStream);


            //写入数据库
            vmFiles = makeVmFiles(size,originalFilename,targetFileName,contentType);


            vmFilesMapper.insert(vmFiles);

            logger.info("saveImg save as is : {} !", targetPathName);
        } catch (Exception e) {
            e.printStackTrace();
            IOUtil.deleteFiles(targetFileName);
            throw e;
        } finally {
            IOUtil.closeStream(inputStream, outputStream);
        }
        return vmFiles.getId();
    }

    @Override
    @Transactional
    public Long cutUploadedImgFile(VmFilesDto vmFilesDto) throws Exception {
        logger.info("cutUploadedImgFile vmFilesDto is : {} !", vmFilesDto);
        VmFiles vmFiles = this.getUsableVmFilesById(vmFilesDto.getFileId());

        //delete temp file
        String filePath = srcConfig.getSrcImgPath();
        String fileName = vmFiles.getFilename();

        final String canNotChangePathName = filePath + fileName;

        String copyFilePathName = filePath + "copy_" + fileName;

        IOUtil.copyFile(canNotChangePathName, copyFilePathName);
        IOUtil.deleteFiles(canNotChangePathName);


        //cut img
        try {
            ImageUtil.crop(copyFilePathName,
                    canNotChangePathName,
                    vmFilesDto.getX(),
                    vmFilesDto.getY(),
                    vmFilesDto.getWidth(),
                    vmFilesDto.getHeight());
            logger.info("cutUploadedImgFile crop file is : {} !", canNotChangePathName);
        } catch (Exception e) {
            throw e;
        }

        //zoom img
        String[] versions = vmFilesDto.getVersions().split(",");
        int originalWidth = vmFilesDto.getWidth();
        int originalHeight = vmFilesDto.getHeight();
        Lists.newArrayList(versions).stream().parallel().forEach((version) -> {
            int intVersion = Integer.valueOf(version);//width
            String targetFilePathName = filePath + version + "_" + fileName;
            try {
                //get zoom
                Double zoom = originalHeight * 1.0 / originalWidth * 1.0;
                int height = (int) (zoom * intVersion);
                ImageUtil.resize(canNotChangePathName, targetFilePathName, intVersion, height);
                logger.info("cutUploadedImgFile resize file is : {} !", targetFilePathName);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        return vmFiles.getId();
    }

    @Override
    public Long uploadAndCut(VmFilesDto vmFilesDto) throws Exception {
        logger.info("uploadAndCut vmFilesDto is : {} !", vmFilesDto);

        Long fileId = this.saveImg(vmFilesDto.getFile());

        vmFilesDto.setFileId(fileId);

        this.cutUploadedImgFile(vmFilesDto);

        return fileId;
    }

    @Override
    public Long uploadVideo(MultipartFile file) throws Exception{
        logger.info("uploadVideo start !!");

        InputStream inputStream = null;
        OutputStream outputStream = null;
        String targetFileName = null;
        String targetFilePathName = null;
        VmFiles vmFiles = null;
        try {
            //uuid
            String uuid = uuid();
            //targetPath
            String targetPath = srcConfig.getSrcVideoPath();
            //contentType
            String contentType = file.getContentType();
            //originalFilename
            String originalFilename = file.getOriginalFilename();
            //get ext
            String ext = IOUtil.getFileNameExt(originalFilename);
            //get size
            Long size = file.getSize();

            targetFileName = uuid + "." + ext;
            targetFilePathName = targetPath + targetFileName;
            //save head Img
            inputStream = file.getInputStream();
            outputStream = new FileOutputStream(targetFilePathName);
            org.apache.commons.io.IOUtils.copy(inputStream, outputStream);

            //写入数据库
            vmFiles = makeVmFiles(size,originalFilename,targetFileName,contentType);

            vmFilesMapper.insert(vmFiles);

            logger.info("uploadVideo save as is : {} !", targetFilePathName);
        } catch (Exception e) {
            e.printStackTrace();
            IOUtil.deleteFiles(targetFileName);
            throw e;
        } finally {
            IOUtil.closeStream(inputStream, outputStream);
        }

        logger.info("uploadVideo end !!");
        return vmFiles.getId();
    }

    private VmFiles makeVmFiles(Long size,String originalFilename,String targetFileName,String contentType) {
        VmFiles vmFiles = new VmFiles();
        Integer now = DateUtil.unixTime().intValue();

        vmFiles.setUpdateTime(now);
        vmFiles.setCreateTime(now);
        vmFiles.setFileSize(size);
        vmFiles.setStatus(BasePo.Status.NORMAL.getCode());
        vmFiles.setIsDeleted(BasePo.IsDeleted.NO.getCode());
        vmFiles.setOriginalName(originalFilename);
        vmFiles.setFilename(targetFileName);
        vmFiles.setContentType(contentType);
        return vmFiles;
    }


    private VmFiles getUsableVmFilesById(Long fileId) {
        return QuickSelectOne.getObjectById(vmFilesMapper, fileId, BasePo.Status.NORMAL, BasePo.IsDeleted.NO);
    }
}
