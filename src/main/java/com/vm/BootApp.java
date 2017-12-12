package com.vm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Title:
 * Description:
 * Author:zhangke
 * Date:2017/11/16 14:47
 */
@SpringBootApplication
@MapperScan(basePackages = "com.vm.dao")
public class BootApp {
    public static void main(String[] args) {
        SpringApplication.run(BootApp.class, args);
    }
}
