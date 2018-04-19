package com.vm.admin.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * Created by ZhangKe on 2018/2/28.
 */
@Component
@RefreshScope
public class VmAdminConfig {

    @Value("${vm.admin.session.lifetime}")
    private Long userSessionLifetime;

    public Long getUserSessionLifetime() {
        return userSessionLifetime;
    }

    public void setUserSessionLifetime(Long userSessionLifetime) {
        this.userSessionLifetime = userSessionLifetime;
    }
}
