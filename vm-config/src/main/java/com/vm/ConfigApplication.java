package com.vm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by ZhangKe on 2018/2/3.
 */

@SpringBootApplication
@ServletComponentScan
@EnableDiscoveryClient
public class ConfigApplication {

    public static void main(String[] args) {

        SpringApplication springApplication = new SpringApplication(ConfigApplication.class);
        springApplication.run(args);

    }

}
