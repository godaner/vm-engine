package com.vm.base.util;

import com.vm.redis.repository.RedisRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

/**
 * Created by ZhangKe on 2018/4/10.
 * 统计缓存
 */
public class CountCacheManager {
    private static Long timeout = -1l;//default (s)

    @Autowired
    private RedisRepository redisRepository;

    private static RedisRepository redisRepositoryCache;

    @PostConstruct
    public void init() {

        this.redisRepositoryCache = this.redisRepository;
    }

    public final static void saveCount(String key, Object countObj) {
        redisRepositoryCache.set(key, SerializeUtil.serialize(countObj), timeout);

    }

    public final static Object getCount(String key) {
        byte[] bytes = (byte[]) redisRepositoryCache.get(key);
        return SerializeUtil.unserialize(bytes);

    }
}
