package com.vm.admin.listener;

import com.vm.admin.config.VmAdminConfig;
import com.vm.base.cache.AdminSessionCacheManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * springboot的监听服务
 */
@Component
public class ApplicationRefreshedListener implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private VmAdminConfig adminConfig;



    private Logger logger = LoggerFactory.getLogger(ApplicationRefreshedListener.class);


    @Override
    @RefreshScope
    public void onApplicationEvent(ContextRefreshedEvent event) {
        try {
            logger.info("ApplicationRefreshedListener starting !");

            adminConfig = event.getApplicationContext().getBean(VmAdminConfig.class);

            AdminSessionCacheManager.setTimeout(adminConfig.getUserSessionLifetime());

            logger.info("ApplicationRefreshedListener start successful !");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("ApplicationRefreshedListener start failed", e);
        }

    }


}