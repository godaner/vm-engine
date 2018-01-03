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
public class BackendApplication {
    public static void main(String[] args) {

        SpringApplication springApplication = new SpringApplication(BackendApplication.class);
//        springApplication.addListeners(new ApplicationStartedListener());
        springApplication.run(args);


    }
}
