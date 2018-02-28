package com.vm.user.util;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by ZhangKe on 2018/1/17.
 */
@Component
public class UserConfig {
    public static Long VM_USER_SESSION_LIFETIME;

    @Value("${vm.user.session.lifetime}")

    public static void setVmUserSessionLifetime(Long vmUserSessionLifetime) {
        VM_USER_SESSION_LIFETIME = vmUserSessionLifetime;
    }
}
