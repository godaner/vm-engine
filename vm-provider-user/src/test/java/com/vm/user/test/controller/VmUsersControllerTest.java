package com.vm.user.test.controller;

import com.vm.base.util.VmControllerBaseUnitTest;
import org.junit.Test;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

/**
 * Created by ZhangKe on 2018/4/10.
 */
public class VmUsersControllerTest extends VmControllerBaseUnitTest {


    @Test
    public void getUserBasicInfo() throws Exception {

        RequestBuilder request = MockMvcRequestBuilders.get("/user/1");

        MvcResult mvcResult = mockMvc.perform(request).andReturn();

        System.out.println(obj2JSONStringWithoutByte(mvcResult));
    }
}
