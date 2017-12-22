package com.vm.controller.impl;


import com.vm.controller.base.ServiceController;
import com.vm.dao.po.VmFiles;
import com.vm.dao.qo.VmMoviesQueryBean;
import com.vm.service.inf.VmFilesService;
import com.vm.utils.VmProperties;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletOutputStream;
import java.io.File;
import java.io.FileInputStream;


/**
 * Created by ZhangKe on 2017/12/13.
 */
@Controller
@RequestMapping("/img")
@Scope("prototype")
public class VmImgController extends ServiceController<VmFilesService> {
    /**
     * 获取电影图片
     *
     * @return
     */
    @RequestMapping(value = "movie/{fileId}", method = RequestMethod.GET)
    public void getMovieImg(@PathVariable("fileId") Long fileId, VmMoviesQueryBean query) throws Exception {
        //获取电影图片id信息
        VmFiles file = service.getFileByFileId(fileId);
        String movieImgPath = VmProperties.VM_MOVIE_IMG_PATH;
        String width = query.getImgWidth();
        String movieImgName = file.getFilename();
        File f = new File(movieImgPath + File.separator + width + "_" + movieImgName);
        //不存在，返回默认图片
        if (!f.exists()) {
            width = VmProperties.VM_MOVIE_IMG_DEFAULT_WIDTH;
            movieImgName = VmProperties.VM_MOVIE_IMG_DEFAULT_NAME;
            f = new File(movieImgPath + File.separator + width + "_" + movieImgName);
        }
        FileInputStream input = new FileInputStream(f);
        ServletOutputStream output = getResponse().getOutputStream();
        //设置响应的媒体类型
        getResponse().setHeader("Content-Type", "image/jped");
        IOUtils.copy(input, output);
        output.close();
        output.flush();
    }

    /**
     * 获取用户头像
     *
     * @return
     */
    @RequestMapping(value = "user/{fileId}", method = RequestMethod.GET)
    public void getUserHead(@PathVariable("fileId") Long fileId, VmMoviesQueryBean query) throws Exception {

    }


}

