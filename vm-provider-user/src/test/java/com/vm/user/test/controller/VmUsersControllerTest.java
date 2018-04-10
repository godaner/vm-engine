package com.vm.user.test.controller;

import com.vm.base.util.VmControllerBaseUnitTest;
import org.junit.Test;
import org.springframework.test.context.ActiveProfiles;

/**
 * Created by ZhangKe on 2018/4/10.
 */
@ActiveProfiles(profiles = "dev")
public class VmUsersControllerTest extends VmControllerBaseUnitTest {


    @Test
    public void getUserBasicInfo() throws Exception {
        g("/user/6");
    }

}
