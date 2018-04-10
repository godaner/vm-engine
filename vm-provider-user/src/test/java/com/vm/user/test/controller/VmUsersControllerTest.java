package com.vm.user.test.controller;

import com.vm.base.util.VmControllerBaseUnitTest;
import org.junit.Test;

/**
 * Created by ZhangKe on 2018/4/10.
 */
public class VmUsersControllerTest extends VmControllerBaseUnitTest {


    @Test
    public void getUserBasicInfo() throws Exception {
        g("/user/1");
    }
}
