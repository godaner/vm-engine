package com.vm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableDiscoveryClient
public class ProviderAdminWSApplication {
    public static void main(String[] args) {

        SpringApplication springApplication = new SpringApplication(ProviderAdminWSApplication.class);
        springApplication.run(args);

    }

}
