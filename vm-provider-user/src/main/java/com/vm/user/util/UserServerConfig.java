package com.vm.user.util;


import com.vm.base.util.ServerConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Created by ZhangKe on 2018/1/17.
 */
@PropertySource(value = {"classpath:userServerConfig.properties"}, encoding = "utf-8")
@Component
@Configuration
public class UserServerConfig extends ServerConfig {
    public static Long VM_USER_SESSION_TIMEOUT;

    @Value("${vm.user.session.timeout}")
    public void setVmUserSessionTimeout(Long vmUserSessionTimeout) {
        VM_USER_SESSION_TIMEOUT = vmUserSessionTimeout;
    }

}
