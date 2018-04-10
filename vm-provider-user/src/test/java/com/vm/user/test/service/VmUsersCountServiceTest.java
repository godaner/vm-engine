package com.vm.user.test.service;

import com.vm.base.util.VmServiceBaseUnitTest;
import com.vm.user.service.inf.VmUsersCountService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by ZhangKe on 2018/4/10.
 */
public class VmUsersCountServiceTest extends VmServiceBaseUnitTest {
    @Autowired
    private VmUsersCountService vmUsersCountService;

    @Test
    public void countUserSex() {
        vmUsersCountService.countUserSex();
    }
}
