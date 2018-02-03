package com.vm.src.controller;

import com.vm.base.util.ServiceController;
import com.vm.src.service.inf.VmSrcService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by ZhangKe on 2018/2/3.
 */
@Controller
@RequestMapping("/src")
@Scope("prototype")
public class VmSrcController extends ServiceController<VmSrcService>{
    /**
     * 获取资源
     *
     * @return
     */
    @RequestMapping(value = "/src/video/{fileId}", method = RequestMethod.GET)
    public void getVideoSrc(@PathVariable("fileId") Long fileId) throws Exception {
        service.sendVideoSrc(fileId, getResponse());
    }
    /**
     * 获取资源
     *
     * @return
     */

    @RequestMapping(value = "/src/img/{fileId}", method = RequestMethod.GET)
    public void getImgSrc(@PathVariable("fileId") Long fileId, Integer width) throws Exception {
        service.sendImgSrc(fileId, width, getResponse());

    }
}
