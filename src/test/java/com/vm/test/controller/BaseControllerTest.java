package com.vm.test.controller;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.ImmutableMap;
import com.vm.BootApp;
import com.vm.base.utils.LoggerWrapper;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.boot.test.rule.OutputCapture;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = BootApp.class)
//@WebAppConfiguration // 使用@WebIntegrationTest注解需要将@WebAppConfiguration注释掉
@WebIntegrationTest("server.port:0")// 使用0表示端口号随机，也可以具体指定如8888这样的固定端口
public class BaseControllerTest {

    @Value("${local.server.port}")// 注入端口号
    protected int port;

    protected static final LoggerWrapper logger = LoggerWrapper.newLoggerWrapper(BaseControllerTest.class);

    @Rule
    // 这里注意，使用@Rule注解必须要用public
    public OutputCapture capture = new OutputCapture();

    protected RestTemplate rt = new RestTemplate();

    /**
     * 获取当前主机测试的url前缀
     * @return
     */
    protected String getLocalHost(){
        return "http://localhost:"+port+"/";
    }

    /**
     * 通过map生成的json字符串类型的 HttpEntity
     * @param map
     * @return
     */
    protected HttpEntity<String> getJsonRequestEntity(Map<Object,Object> map){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        String requestJsonStr = JSON.toJSONString(map);
        HttpEntity<String> entity = new HttpEntity<String>(requestJsonStr,headers);
        return entity;
    }
    @Test
    public void demo(){
        //请求路径
        String url = getLocalHost()+"/temple/a";
        //生成json请求
        HttpEntity<String> entity = getJsonRequestEntity(ImmutableMap.of(
                "username","zhangtsan",
                "password","i"
        ));
        String result = rt.postForObject(url, entity, String.class);
        System.out.println(result);

    }
}