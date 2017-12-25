package com.vm.service.impl;

import com.vm.dao.mapper.CustomVmMoviesMapper;
import com.vm.dao.mapper.CustomVmTagsMapper;
import com.vm.dao.mapper.VmFilesMapper;
import com.vm.dao.po.CustomVmMovies;
import com.vm.dao.po.VmFiles;
import com.vm.dao.po.VmTags;
import com.vm.dao.qo.PageBean;
import com.vm.dao.qo.VmMoviesQueryBean;
import com.vm.service.base.BaseService;
import com.vm.service.inf.VmMoviesService;
import com.vm.utils.VmProperties;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

/**
 * Created by ZhangKe on 2017/12/12.
 */
@Service
public class VmMoviesServiceImpl extends BaseService implements VmMoviesService {
    @Autowired
    private CustomVmMoviesMapper customVmMoviesMapper;
    @Autowired
    private VmFilesMapper vmFilesMapper;
    @Autowired
    private CustomVmTagsMapper customVmTagsMapper;

    @Override
    public List<CustomVmMovies> getMovies(PageBean page, VmMoviesQueryBean query) {
        return customVmMoviesMapper.getMovies(page, query);
    }

    @Override
    public Long getMoviesCount(PageBean page, VmMoviesQueryBean query) {
        return customVmMoviesMapper.getMoviesCount(page, query);
    }
    @Override
    public List<VmTags> getTagsOfMovie(Long movieId) throws Exception {
        return customVmTagsMapper.getTagsOfMovie(movieId);
    }

    @Override
    public CustomVmMovies getMovie(Long movieId) {
        eject(movieId == null, "VmMoviesService#getMovie movieId is null ! movieId is :" + movieId);

        return customVmMoviesMapper.getMovie(movieId);
    }

    @Override
    public void sendMovieImg(Long fileId, VmMoviesQueryBean query, HttpServletResponse response) throws Exception {
        FileInputStream input = null;
        ServletOutputStream output = null;
        try {
            //获取电影图片id信息
            VmFiles file = vmFilesMapper.selectByPrimaryKey(fileId);
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
            input = new FileInputStream(f);
            output = response.getOutputStream();
            //设置响应的媒体类型
            response.setHeader("Content-Type", "image/jped");
            IOUtils.copy(input, output);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeStream(input, output);
        }
    }

    @Override
    public void sendMovieSrc(Long fileId, HttpServletResponse response) throws Exception {

        InputStream input = null;
        OutputStream output = null;
        try {
            VmFiles file = vmFilesMapper.selectByPrimaryKey(fileId);
            String movieSrcPath = VmProperties.VM_MOVIE_SRC_PATH;

            String movieSrcName = null;
            if (file != null) {
                movieSrcName = file.getFilename();
            }
            File f = new File(movieSrcPath + File.separator + movieSrcName);
            //不存在，返回默认图片
            if (!f.exists()) {
                movieSrcName = VmProperties.VM_MOVIE_SRC_DEFAULT_NAME;
                f = new File(movieSrcPath + File.separator + movieSrcName);
            }
            input = new FileInputStream(f);
            output = response.getOutputStream();
            //设置响应的媒体类型
            response.setContentType("video/mp4"); // 设置返回的文件类型

            IOUtils.copy(input, output);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeStream(input, output);
        }
    }


}
