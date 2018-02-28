package com.vm.src.controller;

import com.vm.base.util.Config;
import com.vm.base.util.ServiceController;
import com.vm.src.service.dto.VmFilesDto;
import com.vm.src.service.inf.VmSrcService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by ZhangKe on 2018/2/3.
 */
@Controller
@RequestMapping("/src")
@Scope("prototype")
public class VmSrcController extends ServiceController<VmSrcService> {
    /**
     * 获取视频资源
     *
     * @return
     */
    @RequestMapping(value = "/video", method = RequestMethod.GET)
    public void getVideoSrc(VmFilesDto vmFilesDto) throws Exception {
        service.sendVideoSrc(vmFilesDto, getResponse());
    }

    /**
     * 获取图片资源
     *
     * @return
     */

    @RequestMapping(value = "/img", method = RequestMethod.GET)
    public void getImgSrc(VmFilesDto vmFilesDto) throws Exception {
        service.sendImgSrc(vmFilesDto, getResponse());

    }

    /**
     * 上传图片不剪切
     *
     * @param vmFilesDto
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/img", method = RequestMethod.POST)
    @ResponseBody
    public Object uploadImgFile(VmFilesDto vmFilesDto) throws Exception {
        Long fileId = service.saveImg(vmFilesDto);
        return response.putData("imgUrl", Config.VM_SRC_IMG_URL + "?fileId=" + +fileId).putData("fileId", fileId);
    }

    /**
     * 剪切已存在的文件图片
     *
     * @param vmFilesDto
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/img/cut", method = RequestMethod.POST)
    @ResponseBody
    public Object cutUploadedImgFile(VmFilesDto vmFilesDto) throws Exception {
        Long fileId = service.cutUploadedImgFile(vmFilesDto);
        return response.putData("imgUrl", Config.VM_SRC_IMG_URL + "?fileId=" + fileId);
    }
}
