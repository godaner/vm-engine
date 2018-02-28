package com.vm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;


@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class ProviderUserApplication {
    public static void main(String[] args) {

        SpringApplication springApplication = new SpringApplication(ProviderUserApplication.class);
        springApplication.run(args);

    }

}
