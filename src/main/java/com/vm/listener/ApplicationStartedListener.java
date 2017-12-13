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

        checkAndCreateDir(VmProperties.VM_MOVIE_IMG_PATH);

        checkAndCreateDir(VmProperties.VM_MOVIE_SRC_PATH);

        checkAndCreateDir(VmProperties.VM_USER_IMG_PATH);
    }


    /**
     * 监测dir，如果dir不存在，那么创建
     * @param dirPath
     */
    private void checkAndCreateDir(String dirPath) {
        File dir = new File(dirPath);
        if (!dir.exists()) {
            dir.mkdir();
        }
    }


}