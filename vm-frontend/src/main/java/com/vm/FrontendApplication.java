package com.vm;

import com.vm.frontend.listener.ApplicationStartedListener;
import com.vm.frontend.listener.ApplicationStopedListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;


@SpringBootApplication
@ServletComponentScan
public class FrontendApplication {
    public static void main(String[] args) {

        SpringApplication springApplication = new SpringApplication(FrontendApplication.class);
        springApplication.addListeners(new ApplicationStartedListener());
        springApplication.addListeners(new ApplicationStopedListener());
        springApplication.run(args);

    }

}
