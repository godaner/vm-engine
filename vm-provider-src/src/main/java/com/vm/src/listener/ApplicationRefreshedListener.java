package com.vm.src.listener;

import com.vm.base.VmBaseConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import java.io.File;

/**
 * springboot的监听服务
 */
public class ApplicationRefreshedListener implements ApplicationListener<ContextRefreshedEvent> {

    private VmBaseConfig vmBaseConfig;

    private Logger logger = LoggerFactory.getLogger(ApplicationRefreshedListener.class);

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        try {
            logger.info("ApplicationRefreshedListener starting !");
            vmBaseConfig = event.getApplicationContext().getBean(VmBaseConfig.class);

            //初始化项目目录，例如图片储存，电影储存
            initFileDir();

            logger.info("ApplicationRefreshedListener start successful !");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("ApplicationRefreshedListener start failed", e);
        }

    }

    /**
     * 初始化项目目录，例如图片储存，电影储存
     */
    private void initFileDir() {

        checkAndCreateDir(vmBaseConfig.getSrcImgPath());

        checkAndCreateDir(vmBaseConfig.getSrcVideoPath());

    }


    /**
     * 监测dir，如果dir不存在，那么创建
     *
     * @param dirPath
     */
    private void checkAndCreateDir(String dirPath) {
        File dir = new File(dirPath);
        if (!dir.exists()) {
            logger.info("ApplicationRefreshedListener {} is creating !!",dirPath);
            dir.mkdirs();
            logger.info("ApplicationRefreshedListener {} is created !!",dirPath);
        }else{
            logger.info("ApplicationRefreshedListener {} is exits !!",dirPath);
        }
    }


}