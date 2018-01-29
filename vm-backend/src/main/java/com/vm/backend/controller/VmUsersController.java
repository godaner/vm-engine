package com.vm.backend.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by ZhangKe on 2018/1/16.
 */
@Controller
@RequestMapping("/user")
@Scope("prototype")
public class VmUsersController {

    @RequestMapping(value = "", method = RequestMethod.PUT)
    @ResponseBody
    public void userLogin() throws Exception {

    }
}
