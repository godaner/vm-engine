package com.vm.src.test.controller;

import com.vm.base.util.VmControllerBaseUnitTest;
import org.junit.Test;
import org.springframework.test.context.ActiveProfiles;

/**
 * Created by ZhangKe on 2018/4/10.
 */
@ActiveProfiles(profiles = "dev")
public class VmSrcontrollerTest extends VmControllerBaseUnitTest {


    @Test
    public void getImg() throws Exception {
        g("/src/img/1056/50");
    }

}
