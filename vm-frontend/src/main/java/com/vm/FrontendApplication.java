package com.vm;

import com.vm.frontend.listener.ApplicationStartedListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;


@SpringBootApplication
@ServletComponentScan
public class FrontendApplication {
    public static void main(String[] args) {

        SpringApplication springApplication = new SpringApplication(FrontendApplication.class);
        springApplication.addListeners(new ApplicationStartedListener());
        springApplication.run(args);

    }
}
