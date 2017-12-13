package com.vm.listener;

import com.vm.utils.VmProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;

import java.io.File;

/**
 * springboot启动后的监听服务
 */
public class ApplicationStartedListener implements ApplicationListener<ContextRefreshedEvent> {

    private Logger logger = LoggerFactory.getLogger(ApplicationStartedListener.class);

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        try {
            logger.debug("ApplicationStartedListener starting !");

            //初始化项目目录，例如图片储存，电影储存
            initFileDir();

            logger.debug("ApplicationStartedListener start successful !");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("ApplicationStartedListener start failed", e);
        }

    }

    /**
     * 初始化项目目录，例如图片储存，电影储存
     */
    private void initFileDir() {

        File imgDir = new File(VmProperties.VM_IMG_PATH);
        if (!imgDir.exists()) {
            imgDir.mkdir();
        }
        File movieDir = new File(VmProperties.VM_MOVIE_PATH);
        if (!movieDir.exists()) {
            movieDir.mkdir();
        }

    }


}