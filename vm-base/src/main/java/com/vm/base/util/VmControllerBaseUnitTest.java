package com.vm.base.util;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;

import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

/**
 * Created by ZhangKe on 2018/4/10.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles(profiles = "dev")
public class VmControllerBaseUnitTest extends CommonUtil  {
    private final static Logger logger = LoggerFactory.getLogger(VmControllerBaseUnitTest.class);
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
    protected void p(String url,MultiValueMap<String, String> params) throws Exception {
        mockMvc.perform(post(url).params(params));
    }
    protected void p(String url) throws Exception {
        mockMvc.perform(post(url));
    }
    protected void g(String url,MultiValueMap<String, String> params) throws Exception {
        Object res = mockMvc.perform(get(url).params(params)).andReturn();
        logger.info("[Response url] is : {} ! ",res);
    }
    protected void g(String url) throws Exception {
        Object res = mockMvc.perform(get(url)).andReturn();
        logger.info("[Response url] is : {} ! ",res);
    }
}
