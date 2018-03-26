package com.vm.admin.listener;

import com.vm.admin.config.AdminConfig;
import com.vm.base.aop.SessionManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * springboot的监听服务
 */
public class ApplicationRefreshedListener implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private AdminConfig adminConfig;

    private Logger logger = LoggerFactory.getLogger(ApplicationRefreshedListener.class);

    private final String sessionManagerUniqueId = "adminSessionManager";

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        try {
            logger.info("ApplicationRefreshedListener starting !");

            adminConfig = event.getApplicationContext().getBean(AdminConfig.class);

            SessionManager.set(adminConfig.getUserSessionLifetime(), sessionManagerUniqueId);

            logger.info("ApplicationRefreshedListener start successful !");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("ApplicationRefreshedListener start failed", e);
        }

    }


}