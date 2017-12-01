package com.vm.controller;

import com.google.common.collect.ImmutableMap;
import com.vm.base.bo.Response;
import com.vm.base.utils.LoggerWrapper;
import com.vm.service.exception.VMRuntimeException;
import com.vm.service.exception.ValidateRuntimeException;
import com.vm.service.users.UsersService;
import jdk.nashorn.internal.ir.annotations.Immutable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping("/forward/{name}")
    public Object insert(@PathVariable("name") String name){

        return "forward:frontend/views/"+name;
    }

    @RequestMapping("/query/{id}")
    public Object query(@PathVariable("id") Long id){
        int i = 0;
        i = i/i;
        return ImmutableMap.of("k1","v1","k2","v2");
    }
}
