package com.vm.controller;

import com.vm.base.utils.LoggerWrapper;
import com.vm.service.users.UsersService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * 页面转发
 */
@Controller
@RequestMapping("/")
public class PageHunterController {

    @RequestMapping("/f/{name}")
    public Object frontend(@PathVariable("name") String name) {
        return "frontend/"+name;
    }
    @RequestMapping("/b/{name}")
    public Object backend(@PathVariable("name") String name) {
        return "backend/"+name;
    }


}
