package com.vm.src.controller;

import com.vm.base.util.ServiceController;
import com.vm.dao.po.VmFiles;
import com.vm.src.service.inf.VmSrcService;
import com.vm.src.util.StaticConstants;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
    @RequestMapping(value = "/video/{fileId}", method = RequestMethod.GET)
    public void getVideoSrc(@PathVariable("fileId") Long fileId) throws Exception {
        service.sendVideoSrc(fileId, getResponse());
    }

    /**
     * 获取图片资源
     *
     * @return
     */

    @RequestMapping(value = "/img/{fileId}", method = RequestMethod.GET)
    public void getImgSrc(@PathVariable("fileId") Long fileId, Integer width) throws Exception {
        service.sendImgSrc(fileId, width, getResponse());

    }

    /**
     * 上传图片
     * @param headImg
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/img", method = RequestMethod.POST)
    @ResponseBody
    public Object uploadUserTempHeadImg(@RequestParam("img") MultipartFile headImg) throws Exception {
        Long fileId = service.saveImg(headImg);
        return response.putData("tempImgUrl", StaticConstants.IMG_PREFIX + fileId);
    }
}
