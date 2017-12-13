package com.vm.listener;

import com.mysql.jdbc.log.LogFactory;
import com.vm.base.utils.VmProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import java.io.File;

/**
 * springboot启动时的监听服务
 */
public class ApplicationStartupListener implements ApplicationListener<ContextRefreshedEvent> {

    private Logger logger = LoggerFactory.getLogger(ApplicationStartupListener.class);

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        try {
            logger.debug("ApplicationStartupListener starting !");

            //初始化项目目录，例如图片储存，电影储存
            initFileDir();

            logger.debug("ApplicationStartupListener start successful !");
        } catch (Exception e) {
            logger.error("ApplicationStartupListener start failed", e);
        }
    }

    private void initFileDir() {
        File imgDir = new File(VmProperties.VM_IMG_PATH);
        if(!imgDir.exists()){
            imgDir.mkdir();
        }
        File movieDir = new File(VmProperties.VM_MOVIE_PATH);
        if(!movieDir.exists()){
            movieDir.mkdir();
        }
    }
}