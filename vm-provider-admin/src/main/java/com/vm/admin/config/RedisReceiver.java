package com.vm.admin.config;


import com.vm.auth.admin.cache.AdminSessionCacheManager;
import com.vm.base.util.CommonUtil;
import com.vm.auth.redis.repository.RedisRepository;
import com.vm.mq.sender.AdminOnlineStatusMQSender;
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
        if (isNullObject(message)) {
            return;
        }
        if (message.toString().indexOf(AdminSessionCacheManager.sessionManagerUniqueId) < 0) {
            return;
        }
        String[] infos = message.toString().split(AdminSessionCacheManager.sessionManagerUniqueId);
        String accessToken = infos[infos.length - 1];

        if (CommonUtil.isUuid(accessToken)) {
            AdminOnlineStatusMQSender.tipLogoutWhenUserLoginTimeout(accessToken);
        }
    }
}