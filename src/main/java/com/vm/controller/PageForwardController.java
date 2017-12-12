package com.vm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * 页面转发
 */
@Controller
@RequestMapping("/forward")
public class PageForwardController {

    @RequestMapping("/frontend/{name}")
    public Object frontend(@PathVariable("name") String name) {
        return "frontend/"+name;
    }
    @RequestMapping("/backend/{name}")
    public Object backend(@PathVariable("name") String name) {
        return "backend/"+name;
    }


}
