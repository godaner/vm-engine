package com.vm.src.listener;

import com.vm.src.util.SrcConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

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

        checkAndCreateDir(SrcConfig.VM_SRC_IMG_PATH);

        checkAndCreateDir(SrcConfig.VM_SRC_VIDEO_PATH);

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