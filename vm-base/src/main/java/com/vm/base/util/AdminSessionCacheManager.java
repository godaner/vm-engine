package com.vm.base.util;


import com.google.common.collect.Lists;
import com.vm.redis.repository.RedisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by ZhangKe on 2018/1/17.
 * 记录<token,userId>的键值对,token被记录则代表在线
 */
@Component
public class AdminSessionCacheManager extends CommonUtil {

    private static String sessionManagerUniqueId = AdminSessionCacheManager.class.toString();

    private static Long timeout = 60l;//default (s)

    @Autowired
    private RedisRepository redisRepository;

    private static RedisRepository redisRepositoryCache;

    @PostConstruct
    public void init() {

        this.redisRepositoryCache = this.redisRepository;
    }

    public static Long getTimeout() {
        return timeout;
    }

    public static void setTimeout(Long timeout) {
        AdminSessionCacheManager.timeout = timeout;
    }

    private static String generateToken() {
        return CommonUtil.uuid();
    }

    private static String generateTokenKey(String token) {
        return sessionManagerUniqueId + "_" + token;
    }

    private static String generateUserIdKey(Long userId) {
        return sessionManagerUniqueId + "_" + userId;
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
        String tokenKey = generateTokenKey(token);
        Long userId = getOnlineUserId(tokenKey);

        //clear userIdKey
        String userIdKey = generateUserIdKey(userId);


        redisRepositoryCache.expire(userIdKey, 0);
        redisRepositoryCache.set(userIdKey, null);
        redisRepositoryCache.del(Lists.newArrayList(userIdKey).toString());

        //clear tokenKey
        redisRepositoryCache.expire(tokenKey, 0);
        redisRepositoryCache.set(tokenKey, null);
        redisRepositoryCache.del(Lists.newArrayList(tokenKey).toString());
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
        String tokenKey = generateTokenKey(token);
        Object userId = redisRepositoryCache.get(tokenKey);
        if (userId == null) {
            return;
        }

        //extend tokenKey
        redisRepositoryCache.expire(tokenKey, timeout);

        //extend userIdKey
        String userIdKey = generateUserIdKey((Long) userId);

        redisRepositoryCache.expire(userIdKey, timeout);
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
        String tokenKey = generateTokenKey(token);

        Object userId = redisRepositoryCache.get(tokenKey);
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

        String token = generateToken();
        //save tokenKey

        String tokenKey = generateTokenKey(token);
        redisRepositoryCache.set(tokenKey, userId, timeout);


        //save userIdKey
        String userIdKey = generateUserIdKey(userId);
        redisRepositoryCache.set(userIdKey, token, timeout);

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
                AdminSessionCacheManager.clearSession(token);
    }


}
