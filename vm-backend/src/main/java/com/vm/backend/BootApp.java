package com.vm.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
//@MapperScan(basePackages = "dao")
public class BootApp {
    public static void main(String[] args) {

        SpringApplication springApplication = new SpringApplication(BootApp.class);
//        springApplication.addListeners(new ApplicationStartedListener());
        springApplication.run(args);


    }
}
