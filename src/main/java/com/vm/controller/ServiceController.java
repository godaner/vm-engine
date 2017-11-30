package com.vm.controller;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * <b>Title:</b>
 * <br/>
 * <br/>
 * <b>Description:</b>基础控制器,S为事物对象,接受和返回对象都是json格式;
 * <br/>
 * <br/>@RestController = @ResponseBody + @Controller
 * <b>Author:</b>ZhangKe
 * <br/>
 * <br/>
 * <b>Date:</b>2017/11/24 10:07
 */
public class ServiceController<S> extends BaseController{

    //业务层
    protected S service;
    @Autowired
    public void setS(S service){
        this.service = service;
    };

}
