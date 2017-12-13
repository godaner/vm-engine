package com.vm.controller;



import com.vm.dao.po.VmFiles;
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
import java.io.FileNotFoundException;


/**
 * Created by ZhangKe on 2017/12/13.
 */
@Controller
@RequestMapping("/img")
@Scope("prototype")
public class VmImgController extends ServiceController<VmFilesService>{
    /**
     * path:a.jpg
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public void getImg(@PathVariable("id") Long id) throws Exception {
        //获取此id的文件信息
        VmFiles file = service.getFileByFileId(id);
        File f = new File(VmProperties.VM_MOVIE_IMG_PATH + File.separator+file.getFilename());
        if(!f.exists()){
            f = new File(VmProperties.VM_MOVIE_IMG_PATH + File.separator+VmProperties.VM_MOVIE_IMG_DEFAULT_NAME);
        }
        FileInputStream input = new FileInputStream(f);
        ServletOutputStream output = getResponse().getOutputStream();
        //设置响应的媒体类型
        getResponse().setHeader("Content-Type","image/jped");
        IOUtils.copy(input,output);
        output.close();
        output.flush();
    }


}

