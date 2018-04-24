package com.vm.user.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

/**
 * springboot的监听服务
 */
public class ApplicationRefreshedListener implements ApplicationListener<ContextRefreshedEvent> {

//    @Autowired
//    private VmUserConfig userConfig;

    private Logger logger = LoggerFactory.getLogger(ApplicationRefreshedListener.class);


    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        try {
            logger.info("ApplicationRefreshedListener starting !");
//            userConfig = event.getApplicationContext().getBean(VmUserConfig.class);
//
//            UserSessionCacheManager.setTimeout(userConfig.getUserSessionLifetime());

            logger.info("ApplicationRefreshedListener start successful !");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("ApplicationRefreshedListener start failed", e);
        }

    }


}