package com.vm;

import com.vm.gateway.config.CorsConfig;
import com.vm.gateway.filter.LogFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;

/**
 * Created by ZhangKe on 2017/12/26.
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableZuulProxy // 使用@EnableZuulProxy来开启Zuul的支持，如果你不想使用Zuul提供的Filter和反向代理的功能的话，此处可以使用@EnableZuulServer注解
public class GatewayApplication {
    public static void main(String[] args) {

        SpringApplication springApplication = new SpringApplication(GatewayApplication.class);
        springApplication.run(args);

    }

    @Bean
    public LogFilter logFilter() {
        return new LogFilter();
    }

    @Bean
    public CorsFilter corsFilter() {

        return new CorsConfig().CorsConfig();
    }


}
