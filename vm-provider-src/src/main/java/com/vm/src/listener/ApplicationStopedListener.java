package com.vm.src.listener;

import com.vm.base.config.VmConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStoppedEvent;

/**
 * springboot的监听服务
 */
public class ApplicationStopedListener implements ApplicationListener<ContextStoppedEvent> {

    private Logger logger = LoggerFactory.getLogger(ApplicationStopedListener.class);


    @Override
    public void onApplicationEvent(ContextStoppedEvent event) {
        try {
            logger.info("ApplicationStopedListener stoping !");

            logger.info("ApplicationStopedListener stop successful !");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("ApplicationStopedListener stop failed", e);
        }
    }
}