package com.vm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@ServletComponentScan
@EnableDiscoveryClient
public class ProviderUserApplication {
    public static void main(String[] args) {

        SpringApplication springApplication = new SpringApplication(ProviderUserApplication.class);
        springApplication.run(args);

    }

}
