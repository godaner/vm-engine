package com.vm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableDiscoveryClient
public class ProviderUserWSApplication {
    public static void main(String[] args) {

        SpringApplication springApplication = new SpringApplication(ProviderUserWSApplication.class);
        springApplication.run(args);

    }

}
