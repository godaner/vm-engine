package com.vm.user.util;

import com.vm.base.util.ServerConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Created by ZhangKe on 2018/1/17.
 */
@PropertySource(value = {"classpath:/user-server.properties"}, encoding = "utf-8")
@Component
public class UserServerConfig extends ServerConfig {
    public static Integer VM_USER_SESSION_TIMEOUT;

    @Value("${vm.user.session.timeout}")
    public void setVmUserSessionTimeout(Integer vmUserSessionTimeout) {
        VM_USER_SESSION_TIMEOUT = vmUserSessionTimeout;
    }
}
