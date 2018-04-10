package com.vm.user.timer;

import com.vm.user.service.inf.VmUsersCountService;
import com.vm.user.service.inf.VmUsersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component
public class VmUsersTimer {
    private final static Logger logger = LoggerFactory.getLogger(VmUsersTimer.class);
    @Autowired
    private VmUsersCountService vmUsersCountService;
    @Scheduled(fixedRate = 5000)
    public void timerRate() {
        logger.info("VmUsersTimer timerRate");
    }

    //第一次延迟1秒执行，当执行完后2秒再执行
    @Scheduled(initialDelay = 1000, fixedDelay = 2000)
    public void timerInit() {
        logger.info("VmUsersTimer timerInit");
        vmUsersCountService.countUserSex();

    }

    //每天20点16分50秒时执行
    @Scheduled(cron = "50 16 20 * * ?")
    public void timerCron() {
        logger.info("VmUsersTimer timerCron");
    }
}