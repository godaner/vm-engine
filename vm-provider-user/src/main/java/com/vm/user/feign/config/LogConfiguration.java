package com.vm.user.feign.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class LogConfiguration {

    @Bean
    Logger.Level feignLoggerLevel() {

        return Logger.Level.FULL;

    }

}