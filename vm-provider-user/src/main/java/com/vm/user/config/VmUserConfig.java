package com.vm.user.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * Created by ZhangKe on 2018/2/28.
 */
@Component
@RefreshScope
public class VmUserConfig {

    @Value("${vm.user.session.lifetime}")
    private Long userSessionLifetime;
    @Value("${vm.user.img.versions}")
    private String userImgVersions;

    public String getUserImgVersions() {
        return userImgVersions;
    }

    public void setUserImgVersions(String userImgVersions) {
        this.userImgVersions = userImgVersions;
    }

    public Long getUserSessionLifetime() {
        return userSessionLifetime;
    }

    public void setUserSessionLifetime(Long userSessionLifetime) {
        this.userSessionLifetime = userSessionLifetime;
    }
}
