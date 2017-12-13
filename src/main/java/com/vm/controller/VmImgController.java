package com.vm.controller;

import com.vm.base.utils.VmProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.File;


/**
 * Created by ZhangKe on 2017/12/13.
 */
@Controller
@RequestMapping("/img")
public class VmImgController extends BaseController{
    /**
     * path:a.jpg
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public void getImg(@PathVariable("id") String id) {
        System.out.println(id);
        System.out.println();
        
        File img = new File(VmProperties.VM_IMG_PATH + File.separator+id+".png");

    }


}

