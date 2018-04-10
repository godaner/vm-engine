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

    @Scheduled(initialDelay = 1000, fixedDelay = 60*1000*60)
    public void countUserSex() {
        logger.info("VmUsersTimer start !");
        vmUsersCountService.countUserSex();
        vmUsersCountService.countUserLoginArea();
        logger.info("VmUsersTimer end !");
    }


}