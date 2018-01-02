package com.vm.frontend.controller;

import com.vm.base.utils.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * 页面索引
 */
@Controller
@RequestMapping("/")
public class IndexController extends BaseController{
    @RequestMapping("/")
    public Object index() {
        return "index";
    }
    @RequestMapping("/{page}")
    public Object forward(@PathVariable("page") String page) {
        return page;
    }

}
