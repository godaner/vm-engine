package com.vm.admin.config;

import com.vm.admin.resolver.OnlineAdminMethodArgumentResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

/**
 * 注册Resolver
 */
@Configuration
public class ResolverConfig extends WebMvcConfigurerAdapter {

    @Autowired
    private OnlineAdminMethodArgumentResolver onlineUserMethodArgumentResolver;
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
//        super.addArgumentResolvers(argumentResolvers);
        argumentResolvers.add(onlineUserMethodArgumentResolver);
    }
}