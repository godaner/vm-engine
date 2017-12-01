package com.vm.controller;

import com.google.common.collect.ImmutableMap;
import com.vm.base.utils.LoggerWrapper;
import com.vm.service.users.UsersService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;


/**
 * <b>Title:</b>
 * <br/>
 * <br/>
 * <b>Description:</b>
 * <br/>
 * <br/>
 * <b>Author:</b>ZhangKe
 * <br/>
 * <br/>
 * <b>Date:</b>2017/11/17 13:12
 */
@Controller
@RequestMapping("/users")
public class UsersController extends ServiceController<UsersService> {

    private LoggerWrapper logger = LoggerWrapper.newLoggerWrapper(UsersController.class);

    @RequestMapping("/a")
    public String insert(Model model) {

        model.addAttribute("name", "厉害了!!");

        return "frontend/views/index";
    }

    @RequestMapping("/query/{id}")
    public Object query(@PathVariable("id") Long id) {
        int i = 0;
        i = i / i;
        return ImmutableMap.of("k1", "v1", "k2", "v2");
    }
}
