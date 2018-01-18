package com.vm.frontend.util;


import com.google.common.collect.Maps;
import com.vm.base.util.CommonUtil;
import com.vm.redis.repository.RedisRepository;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by ZhangKe on 2018/1/17.
 * 记录<token,userId>的键值对,token被记录则代表在线
 */
@Component
public class SessionManager extends CommonUtil {

    private final static Long timeout = FrontendServerConfig.VM_USER_SESSION_TIMEOUT;

    private final static String ONLINE_USER_REDIS_MAP_KEY = "ONLINE_USER_REDIS_MAP_KEY";

    @Autowired
    private RedisRepository redisRepository;

    private static RedisRepository redisRepositoryCache;

    @PostConstruct
    public void init() {
        this.redisRepositoryCache = this.redisRepository;
    }

    /**
     * 清空SessionMnanger
     *
     * @return
     */
    public final static boolean clearSessionManager() {
        redisRepositoryCache.hmset(ONLINE_USER_REDIS_MAP_KEY, Maps.newHashMap());
        return true;
    }

    /**
     * 清空session
     *
     * @param token
     * @return
     */
    public static Object clearSession(String token) {
        Object[] keys = Lists.newArrayList(token).toArray();
        redisRepositoryCache.hdel(ONLINE_USER_REDIS_MAP_KEY, keys);
        return true;
    }

    /**
     * 获取在线用户id
     *
     * @param token
     * @return
     */
    public static Object getOnlineUserInfo(String token) {
        return redisRepositoryCache.hget(ONLINE_USER_REDIS_MAP_KEY, token);
    }

    /**
     * 用户登录,储存器在线id
     *
     * @param info
     * @return
     */
    public static String userLogin(Object info) {
        String token = CommonUtil.uuid();
        logger.info(timeout.toString());
        boolean res = redisRepositoryCache.hset(ONLINE_USER_REDIS_MAP_KEY, token, info, timeout);
        return token;
    }

    /**
     * 用户退出
     *
     * @param token
     * @return
     */
    public static boolean userLogout(String token) {
        redisRepositoryCache.hdel(ONLINE_USER_REDIS_MAP_KEY, token);
        return true;
    }
}
