package com.vm.admin.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * springboot的监听服务
 */
public class ApplicationRefreshedListener implements ApplicationListener<ContextRefreshedEvent> {

//    @Autowired
//    private VmAdminConfig adminConfig;


    private Logger logger = LoggerFactory.getLogger(ApplicationRefreshedListener.class);


    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        try {
            logger.info("ApplicationRefreshedListener starting !");

//            adminConfig = event.getApplicationContext().getBean(VmAdminConfig.class);
//
//            AdminSessionCacheManager.setTimeout(adminConfig.getUserSessionLifetime());

            logger.info("ApplicationRefreshedListener start successful !");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("ApplicationRefreshedListener start failed", e);
        }

    }


}