package com.vm.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by eggyer on 2017/3/13.
 */

@RestController
public class ConfigClientController {
        //取配置文件中的值
    @Value("${profile}")
    private String profile;

    @GetMapping("/profile")
    public String getProfile(){
        return profile;
    }
    @GetMapping("/")
    public String index() {
        return "ProviderUserApplication";
    }
}