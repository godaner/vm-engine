package com.vm.frontend.listener;

import com.vm.base.util.ServerConfig;
import com.vm.frontend.util.SessionManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import javax.annotation.Resource;
import java.io.File;

/**
 * springboot启动后的监听服务
 */
public class ApplicationStartedListener implements ApplicationListener<ContextRefreshedEvent> {

    private Logger logger = LoggerFactory.getLogger(ApplicationStartedListener.class);

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        try {
            logger.info("ApplicationStartedListener starting !");

            //初始化项目目录，例如图片储存，电影储存
            initFileDir();

            //clear user session
//            SessionManager.clearSessionManager();

            logger.info("ApplicationStartedListener start successful !");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("ApplicationStartedListener start failed", e);
        }

    }

    /**
     * 初始化项目目录，例如图片储存，电影储存
     */
    private void initFileDir() {

        checkAndCreateDir(ServerConfig.VM_MOVIE_IMG_PATH);

        checkAndCreateDir(ServerConfig.VM_MOVIE_SRC_PATH);

        checkAndCreateDir(ServerConfig.VM_USER_IMG_PATH);

        checkAndCreateDir(ServerConfig.VM_FILMMAKER_IMG_PATH);

        checkAndCreateDir(ServerConfig.VM_USER_IMG_TEMP_PATH);
    }


    /**
     * 监测dir，如果dir不存在，那么创建
     * @param dirPath
     */
    private void checkAndCreateDir(String dirPath) {
        File dir = new File(dirPath);
        if (!dir.exists()) {
            dir.mkdirs();
        }
    }


}