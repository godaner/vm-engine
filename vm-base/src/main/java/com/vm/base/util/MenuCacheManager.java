package com.vm.base.util;

import com.google.common.collect.Lists;
import com.vm.redis.repository.RedisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Created by ZhangKe on 2018/3/28.
 */
@Component
public class MenuCacheManager extends CommonUtil {

    private static String sessionManagerUniqueId = "menuCacheManager_";

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

    public static void saveMenuTree(String accessToken, List authCodes) {

        redisRepositoryCache.set(generateKey(accessToken), authCodes, timeout);
    }

    public static List getMenuTree(String accessToken) {
        return (List) redisRepositoryCache.get(generateKey(accessToken));
    }


    public static void clearMenuTree(String accessToke) {

        redisRepositoryCache.expire(generateKey(accessToke), 0);
        redisRepositoryCache.set(generateKey(accessToke), null);
        redisRepositoryCache.del(Lists.newArrayList(generateKey(accessToke)).toString());
    }

}
