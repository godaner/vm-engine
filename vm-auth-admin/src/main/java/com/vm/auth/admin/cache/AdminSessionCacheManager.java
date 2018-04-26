package com.vm.auth.admin.cache;


import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.vm.auth.redis.repository.RedisRepository;
import com.vm.base.config.VmBaseConfig;
import com.vm.base.util.CommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Map;

/**
 * Created by ZhangKe on 2018/1/17.
 * 记录<token,userId>的键值对,token被记录则代表在线
 */
@Component
@RefreshScope
public class AdminSessionCacheManager extends CommonUtil {

    public final static String sessionManagerUniqueId = "AdminSessionCacheManager_";

    private final static Logger logger = LoggerFactory.getLogger(AdminSessionCacheManager.class);

    @Autowired
    private RedisRepository redisRepository;

    private static RedisRepository redisRepositoryCache;

    @Autowired
    private VmBaseConfig vmBaseConfig;

    private static VmBaseConfig vmBaseConfigCache;

    @PostConstruct
    public void init() {

        this.redisRepositoryCache = this.redisRepository;
        this.vmBaseConfigCache = this.vmBaseConfig;
    }


    private static String generateToken() {
        return CommonUtil.uuid();
    }

    private static String generateTokenKey(String token) {
        return sessionManagerUniqueId + token;
    }

    private static String generateUserIdKey(Long userId) {
        return sessionManagerUniqueId + userId;
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
    public static Map extendSessionLife(String token) {
        if (null == token) {
            return null;
        }
        String tokenKey = generateTokenKey(token);
        Object userId = redisRepositoryCache.get(tokenKey);
        if (userId == null) {
            return null;
        }

        Long timeout = Long.valueOf(vmBaseConfigCache.getAdminSessionLifetime().toString());
        //extend tokenKey
        redisRepositoryCache.expire(tokenKey, timeout);

        //extend userIdKey
        String userIdKey = generateUserIdKey((Long) userId);

        redisRepositoryCache.expire(userIdKey, timeout);
        return ImmutableMap.of(
                "userId", userId,
                "token", token
        );
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
            throw new Exception("AdminSessionCacheManager token info is null ! userId is : " + userId);
        }

        String token = generateToken();
        Long timeout = Long.valueOf(vmBaseConfigCache.getAdminSessionLifetime().toString());
        //save tokenKey

        String tokenKey = generateTokenKey(token);
        redisRepositoryCache.set(tokenKey, userId, timeout);


        //save userIdKey
        String userIdKey = generateUserIdKey(userId);
        redisRepositoryCache.set(userIdKey, token, timeout);

        logger.info("AdminSessionCacheManager login user id is : {} , token is : {} , timeout is : {} !", userId, token, timeout);


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
