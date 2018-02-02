package com.vm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@ServletComponentScan
@EnableDiscoveryClient
public class ProviderMovieApplication {
    public static void main(String[] args) {

        SpringApplication springApplication = new SpringApplication(ProviderMovieApplication.class);
        springApplication.run(args);

    }

}
