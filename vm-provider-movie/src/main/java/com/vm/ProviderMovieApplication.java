package com.vm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;


@SpringBootApplication
@ServletComponentScan
@EnableDiscoveryClient
@EnableFeignClients
public class ProviderMovieApplication {
    public static void main(String[] args) {

        SpringApplication springApplication = new SpringApplication(ProviderMovieApplication.class);
        springApplication.run(args);

    }

}
