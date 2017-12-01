package com.vm.controller;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by ZhangKe on 2017/11/24.
 */
public class ServiceController<S> extends BaseController {

    //业务层
    protected S service;

    @Autowired
    public void setS(S service) {
        this.service = service;
    }

}
