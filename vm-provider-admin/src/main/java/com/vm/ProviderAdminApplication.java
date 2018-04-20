package com.vm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * Created by ZhangKe on 2018/2/3.
 */


@SpringBootApplication
@ServletComponentScan
@EnableDiscoveryClient
@EnableRedisHttpSession
public class ProviderAdminApplication {

    public static void main(String[] args) {

        SpringApplication springApplication = new SpringApplication(ProviderAdminApplication.class);
        springApplication.run(args);

    }

}
