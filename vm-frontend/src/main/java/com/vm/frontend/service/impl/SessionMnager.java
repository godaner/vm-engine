package com.vm.frontend.service.impl;

import com.google.common.collect.Maps;
import com.vm.base.util.CommonUtil;
import com.vm.dao.redis.RedisService;
import com.vm.frontend.util.FrontendServerConfig;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by ZhangKe on 2018/1/17.
 */
public class SessionMnager {

    private final static Long timeout = FrontendServerConfig.VM_USER_SESSION_TIMEOUT;

    private final static String ONLINE_USER_REDIS_MAP_KEY = "ONLINE_USER_REDIS_MAP_KEY";


    @Autowired
    private static RedisService redisService;

    static {
        redisService.hmset(ONLINE_USER_REDIS_MAP_KEY, Maps.newHashMap());
    }


    public static Object getOnlineUser(String token) {
        return redisService.hget(ONLINE_USER_REDIS_MAP_KEY, token);
    }

    public static String userLogin(Object info) {
        String token = CommonUtil.uuid();
        redisService.hset(ONLINE_USER_REDIS_MAP_KEY, token, info, timeout);
        return token;
    }

    public static boolean userLogout(String token) {
        redisService.hdel(ONLINE_USER_REDIS_MAP_KEY, token);
        return true;
    }
}
