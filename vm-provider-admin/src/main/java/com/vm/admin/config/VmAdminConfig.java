package com.vm.admin.config;


import com.vm.base.cache.ConfigCacheManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * Created by ZhangKe on 2018/2/28.
 */
@Component
@RefreshScope
public class VmAdminConfig {

    private Long userSessionLifetime;

    public Long getUserSessionLifetime() {
        return userSessionLifetime;
    }

    @Value("${vm.admin.session.lifetime}")
    public void setUserSessionLifetime(Long userSessionLifetime) {


        ConfigCacheManager.savePro("vm.admin.session.lifetime",userSessionLifetime);
        this.userSessionLifetime = userSessionLifetime;
    }
}
