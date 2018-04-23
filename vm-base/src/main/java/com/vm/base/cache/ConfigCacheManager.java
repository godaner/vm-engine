package com.vm.base.cache;

import com.vm.redis.repository.RedisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * Created by ZhangKe on 2018/4/23.
 * 将配置信息持久化到redis以便全局使用
 */
@Component
public class ConfigCacheManager {
    private static String managerUniqueId = "configCacheManager_";

    private static Long timeout = -1l;//default (s)

    @Autowired
    private RedisRepository redisRepository;

    private static RedisRepository redisRepositoryCache;

    private static String generateKey(String key) {
        return managerUniqueId + key;
    }

    @PostConstruct
    public void init() {
        this.redisRepositoryCache = this.redisRepository;
    }

    public static void savePro(String key, Object val) {

        redisRepositoryCache.set(generateKey(key), val, timeout);
    }

    public static Object getPro(String key) {
        return redisRepositoryCache.get(generateKey(key));
    }


}
