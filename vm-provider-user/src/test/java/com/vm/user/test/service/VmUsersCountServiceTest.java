package com.vm.user.test.service;

import com.vm.base.util.VmServiceBaseUnitTest;
import com.vm.user.service.inf.VmUsersCountService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;

/**
 * Created by ZhangKe on 2018/4/10.
 * service层测试，不自带打印
 */
@ActiveProfiles(profiles = "dev")
public class VmUsersCountServiceTest extends VmServiceBaseUnitTest {
    @Autowired
    private VmUsersCountService vmUsersCountService;

    @Test
    public void countUserSex() {
        vmUsersCountService.countUserSex();
    }
    @Test
    public void getUserSexCount() {

        print(vmUsersCountService.getUserSexCount());
    }
    @Test
    public void getUserAreaCount() {

        print(vmUsersCountService.getUserAreaCount());
    }

}
