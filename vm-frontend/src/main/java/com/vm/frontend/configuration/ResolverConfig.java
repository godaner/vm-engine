package com.vm.frontend.configuration;

import com.vm.frontend.resolver.OnlineUserMethodArgumentResolver;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

/**
 * 注册Resolver
 */
@Configuration
public class ResolverConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
//        super.addArgumentResolvers(argumentResolvers);
        argumentResolvers.add(new OnlineUserMethodArgumentResolver());
    }
}