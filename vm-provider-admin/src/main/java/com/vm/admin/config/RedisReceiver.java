package com.vm.admin.config;

import com.vm.admin.ws.AdminOnlineStatusWSController;
import com.vm.base.cache.AdminSessionCacheManager;
import com.vm.base.util.CommonUtil;
import com.vm.redis.repository.RedisRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RedisReceiver extends CommonUtil {

    @Autowired
    private RedisRepository redisRepository;
    final static Logger logger = LoggerFactory.getLogger(RedisReceiver.class);

    public void receiveMessage(Object message) {
        //这里是收到通道的消息之后执行的方法
        logger.info("RedisReceiver receiveMessage message is : {} ! ", message);
        Object val = redisRepository.get((String) message);
        logger.info("RedisReceiver receiveMessage val is : {} ! ", val);
        String valStr = ((String) message).split("_")[1];
        if (isNullObject(valStr) || isEmptyString(valStr)) {
            return;
        }
        Long userId = AdminSessionCacheManager.getOnlineUserId(valStr);
        if (isNullObject(userId)) {
            return;
        }
        AdminOnlineStatusWSController.tipLogoutWhenUserLoginTimeout(valStr);
    }
}