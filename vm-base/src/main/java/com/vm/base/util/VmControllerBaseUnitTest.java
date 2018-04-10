package com.vm.base.util;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * Created by ZhangKe on 2018/4/10.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles(profiles = "dev")
public class VmControllerBaseUnitTest extends CommonUtil  {
    //@Autowired
    protected MockMvc mockMvc;

    @Autowired
    protected WebApplicationContext webApplicationContext;

    @Before
    public void setup(){
        //MockMvcBuilders使用构建MockMvc对象   （项目拦截器有效）
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

        //单个类  拦截器无效
        // mockMvc = MockMvcBuilders.standaloneSteup(userController).build();

    }
}
