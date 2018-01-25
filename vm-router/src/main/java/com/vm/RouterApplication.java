package com.vm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@ServletComponentScan
@EnableDiscoveryClient
public class RouterApplication {
    public static void main(String[] args) {

        SpringApplication springApplication = new SpringApplication(RouterApplication.class);
        springApplication.run(args);

    }

}
