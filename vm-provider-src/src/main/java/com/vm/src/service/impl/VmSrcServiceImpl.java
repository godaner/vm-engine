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
    public void sendVideoSrc(VmFilesDto vmFilesDto, HttpServletResponse response) throws IOException, NoSuchAlgorithmException {

        logger.info("sendVideoSrc vmFilesDto is : {} , response is : {} !", vmFilesDto, response);

        Long fileId = vmFilesDto.getFileId();
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
    public void sendImgSrc(VmFilesDto vmFilesDto, HttpServletResponse response) throws IOException {
        logger.info("sendImgSrc vmFilesDto is : {} !", vmFilesDto);
        Long fileId = vmFilesDto.getFileId();
        Integer width = vmFilesDto.getWidth();
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
        if (null == width) {
            imgPathName = imgPath + imgName;
            if (!new File(imgPathName).exists()) {
                logger.error("sendImgSrc file :{} is not exits ！", imgPathName);
                imgPathName = imgPath + srcConfig.getSrcImgDefault();
            }
            sendFileToHttpResponse(imgPathName, contentType, response);
            return;
        }
        imgPathName = imgPath + File.separator + width + "_" + imgName;
        if (!new File(imgPathName).exists()) {
            logger.error("sendImgSrc file :{} is not exits ！", imgPathName);
            imgPathName = imgPath + imgName;
            if (!new File(imgPathName).exists()) {
                logger.error("sendImgSrc file :{} is not exits ！", imgPathName);
                imgPathName = imgPath + srcConfig.getSrcImgDefault();
            }
        }
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
    public Long saveImg(VmFilesDto vmFilesDto) throws IOException {

        logger.info("saveImg vmFilesDto is : {}", vmFilesDto);

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
            IOUtil.deleteFiles(targetImgName);
            throw e;
        } finally {
            IOUtil.closeStream(inputStream, outputStream);
        }
        return vmFiles.getId();
    }

    @Override
    @Transactional
    public Long cutUploadedImgFile(VmFilesDto vmFilesDto) throws Exception {
        logger.info("sendImgSrc vmFilesDto is : {} !", vmFilesDto);
        VmFiles vmFiles = this.getUsableVmFilesById(vmFilesDto.getFileId());

        String filePath = srcConfig.getSrcImgPath();
        String fileName = vmFiles.getFilename();
//        String filePathName = filePath + fileName;
        String sourceFilePathName = filePath + fileName;
        String cutTargetFilePathName = filePath +"cut_"+ fileName;

//        String ext = getFileNameExt(fileName);
        String[] versions = vmFilesDto.getVersions().split(",");

        //cut img
        try {
            ImageUtil.crop(sourceFilePathName,
                    cutTargetFilePathName,
                    vmFilesDto.getX(),
                    vmFilesDto.getY(),
                    vmFilesDto.getWidth(),
                    vmFilesDto.getHeight());
            IOUtil.deleteFiles(sourceFilePathName);
        } catch (Exception e){
            throw e;
        }

        //zoom img
        int originalWidth = vmFilesDto.getWidth();
                int originalHeight = vmFilesDto.getHeight();
        Lists.newArrayList(versions).stream().parallel().forEach((version) -> {
            int intVersion = Integer.valueOf(version);//width
            String targetFilePathName = filePath + version + "_" + fileName;
            try {
                int height = (originalHeight/originalWidth)*intVersion;
                ImageUtil.resize(cutTargetFilePathName,targetFilePathName,intVersion,height);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        return vmFiles.getId();
    }

    @Override
    public Long uploadAndCut(VmFilesDto vmFilesDto) throws Exception {
        logger.info("uploadAndCut vmFilesDto is : {} !", vmFilesDto);

        Long fileId = this.saveImg(vmFilesDto);

        vmFilesDto.setFileId(fileId);

        this.cutUploadedImgFile(vmFilesDto);

        return fileId;
    }


    private VmFiles getUsableVmFilesById(Long fileId) {
        return QuickSelectOne.getObjectById(vmFilesMapper, fileId, BasePo.Status.NORMAL, BasePo.IsDeleted.NO);
    }
}
