package com.vm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class BackendApplication {
    public static void main(String[] args) {

        SpringApplication springApplication = new SpringApplication(BackendApplication.class);
        springApplication.run(args);


    }
}
