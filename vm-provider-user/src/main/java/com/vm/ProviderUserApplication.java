package com.vm;

import com.vm.user.listener.ApplicationRefreshedListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;


@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@ServletComponentScan
public class ProviderUserApplication {
    public static void main(String[] args) {

        SpringApplication springApplication = new SpringApplication(ProviderUserApplication.class);
        springApplication.addListeners(new ApplicationRefreshedListener());
        springApplication.run(args);

    }

}
