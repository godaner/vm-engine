package com.vm.user.util;


import com.google.common.collect.Lists;
import com.vm.base.util.CommonUtil;
import com.vm.redis.repository.RedisRepository;
import com.vm.user.config.UserConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by ZhangKe on 2018/1/17.
 * 记录<token,userId>的键值对,token被记录则代表在线
 */
@Component
public class SessionManager extends CommonUtil {

    private final static String LOGIN_USER_KEY_PREFIX = "login_user_";

    @Autowired
    private UserConfig userConfig;
    private static UserConfig userConfigCache;

    private static Long timeout = null;

    @Autowired
    private RedisRepository redisRepository;

    private static RedisRepository redisRepositoryCache;

    @PostConstruct
    public void init() {

        this.redisRepositoryCache = this.redisRepository;
        this.userConfigCache = this.userConfig;
        this.timeout = this.userConfigCache.getUserSessionLifetime();
    }


    private static String generateToken() {
        return CommonUtil.uuid();
    }

    private static String generateUserIdKey(Long userId) {
        return LOGIN_USER_KEY_PREFIX + userId;
    }

    /**
     * 清空session
     *
     * @param token
     * @return
     */
    public static Object clearSession(String token) {
        if (null == token) {
            return true;
        }
        Long userId = getOnlineUserId(token);

        //clear userId
        String userIdKey = generateUserIdKey(userId);


        redisRepositoryCache.expire(userIdKey, 0);
        redisRepositoryCache.set(userIdKey, null);
        redisRepositoryCache.del(Lists.newArrayList(userIdKey).toString());

        //clear token
        redisRepositoryCache.expire(token, 0);
        redisRepositoryCache.set(token, null);
        redisRepositoryCache.del(Lists.newArrayList(token).toString());
        return true;
    }

    /**
     * 延长session生命时间
     *
     * @param token
     * @return
     */
    public static void extendSessionLife(String token) {
        if (null == token) {
            return;
        }
        Object userId = redisRepositoryCache.get(token);
        if (userId == null) {
            return;
        }

        //extend token
        redisRepositoryCache.expire(token, timeout);

        //extend userId
        Long userIdLong = (Long) userId;

        redisRepositoryCache.expire(generateUserIdKey(userIdLong), timeout);
    }


    /**
     * 获取在线用户userId
     *
     * @param token
     * @return
     */
    public static Long getOnlineUserId(String token) {
        if (null == token) {
            return null;
        }
        Object userId = redisRepositoryCache.get(token);
        if (null == userId) {
            return null;
        }
        return (Long) userId;
    }

    /**
     * 获取在线用户的token
     *
     * @param userId
     * @return
     */
    public static String getOnlineUserToken(Long userId) {
        if (null == userId) {
            return null;
        }
        Object token = redisRepositoryCache.get(generateUserIdKey(userId));
        if (null == token) {
            return null;
        }
        return (String) token;
    }

    /**
     * 用户登录,储存器在线id
     *
     * @return
     */
    public static String userLogin(Long userId) throws Exception {
        if (userId == null) {
            throw new Exception("SessionManager token info is null ! userId is : " + userId);
        }

        //save token
        String token = generateToken();
        redisRepositoryCache.set(token, userId, timeout);


        //save userId
        redisRepositoryCache.set(generateUserIdKey(userId), token, timeout);

        return token;
    }


    /**
     * 用户退出
     *
     * @param token
     * @return
     */
    public static boolean userLogout(String token) {
        return (boolean)
                SessionManager.clearSession(token);
    }

}
