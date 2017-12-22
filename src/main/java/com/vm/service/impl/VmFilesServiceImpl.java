package com.vm.service.impl;

import com.vm.dao.mapper.VmFilesMapper;
import com.vm.dao.po.VmFiles;
import com.vm.dao.qo.VmMoviesQueryBean;
import com.vm.service.base.BaseService;
import com.vm.service.inf.VmFilesService;
import com.vm.utils.VmProperties;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;

/**
 * Created by ZhangKe on 2017/12/13.
 */
@Service
public class VmFilesServiceImpl extends BaseService implements VmFilesService {
    @Autowired
    private VmFilesMapper vmFilesMapper;


    @Override
    public void getMovieImg(Long fileId, VmMoviesQueryBean query, HttpServletResponse response) throws Exception {
        //获取电影图片id信息
        VmFiles file = vmFilesMapper.selectByPrimaryKey(fileId);
        ;
        String movieImgPath = VmProperties.VM_MOVIE_IMG_PATH;
        String width = query.getImgWidth();
        String movieImgName = null;
        if (file != null) {
            movieImgName = file.getFilename();
        }
        File f = new File(movieImgPath + File.separator + width + "_" + movieImgName);
        //不存在，返回默认图片
        if (!f.exists()) {
            width = VmProperties.VM_MOVIE_IMG_DEFAULT_WIDTH;
            movieImgName = VmProperties.VM_MOVIE_IMG_DEFAULT_NAME;
            f = new File(movieImgPath + File.separator + width + "_" + movieImgName);
        }
        FileInputStream input = new FileInputStream(f);
        ServletOutputStream output = response.getOutputStream();
        //设置响应的媒体类型
        response.setHeader("Content-Type", "image/jped");
        IOUtils.copy(input, output);
        output.close();
        output.flush();
    }
}
