package com.vm.base.cache;

import com.google.common.collect.Lists;
import com.vm.base.util.CommonUtil;
import com.vm.redis.repository.RedisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Created by ZhangKe on 2018/3/28.
 */
@Component
public class AuthCacheManager extends CommonUtil {

    private static String sessionManagerUniqueId = "authCacheManager_";

    private static Long timeout = -1l;//default (s)

    @Autowired
    private RedisRepository redisRepository;

    private static RedisRepository redisRepositoryCache;

    private static String generateKey(String key) {
        return sessionManagerUniqueId + key;
    }

    @PostConstruct
    public void init() {

        this.redisRepositoryCache = this.redisRepository;
    }

    public static void saveAuthCodes(String accessToken, List<String> authCodes) {

        redisRepositoryCache.set(generateKey(accessToken), authCodes, timeout);
    }

    public static List<String> getAuthCodes(String accessToken) {
        return (List<String>) redisRepositoryCache.get(generateKey(accessToken));
    }


    public static void clearAuthCodes(String accessToke) {

        redisRepositoryCache.expire(generateKey(accessToke), 0);
        redisRepositoryCache.set(generateKey(accessToke), null);
        redisRepositoryCache.del(Lists.newArrayList(generateKey(accessToke)).toString());
    }

}
