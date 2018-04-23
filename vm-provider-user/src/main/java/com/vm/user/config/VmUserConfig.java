package com.vm.user.config;


import com.vm.base.cache.ConfigCacheManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * Created by ZhangKe on 2018/2/28.
 */
@Component
@RefreshScope
public class VmUserConfig {

    private Long userSessionLifetime;
    private String userImgVersions;

    public String getUserImgVersions() {
        return userImgVersions;
    }

    @Value("${vm.user.img.versions}")
    public void setUserImgVersions(String userImgVersions) {
        this.userImgVersions = userImgVersions;
    }

    public Long getUserSessionLifetime() {
        return userSessionLifetime;
    }

    @Value("${vm.user.session.lifetime}")
    public void setUserSessionLifetime(Long userSessionLifetime) {

        ConfigCacheManager.savePro("vm.user.session.lifetime",userSessionLifetime);
        this.userSessionLifetime = userSessionLifetime;
    }
}
