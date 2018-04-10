package com.vm.user.test.controller;

import com.vm.base.util.VmControllerBaseUnitTest;
import org.junit.Test;
import org.springframework.test.context.ActiveProfiles;

/**
 * Created by ZhangKe on 2018/4/10.
 */
@ActiveProfiles(profiles = "dev")
public class VmUsersCountControllerTest extends VmControllerBaseUnitTest {

    @Test
    public void getUserSexCount() throws Exception {
        g("/user/count/sex");
    }
    @Test
    public void getUserLoginAreaCount() throws Exception {
        g("/user/count/login_area");
    }
}
