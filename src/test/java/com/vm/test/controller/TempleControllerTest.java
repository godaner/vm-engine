package com.vm.test.controller;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.ImmutableMap;
import com.vm.controller.TempleController;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertThat;

/**
 * Created by ZhangKe on 2017/12/1.
 */
public class TempleControllerTest extends  BaseControllerTest{
    @Test
    public void test4(){

        String url = getLocalHost()+"/temple/a";
//        String url = getLocalHost()+"/temple/b";
        /*json请求*/
        HttpEntity<String> entity = getJsonRequestEntity(ImmutableMap.of(
                "username","key1value",
                "password","key2value"
        ));
        String result = rt.postForObject(url, entity, String.class);
        System.out.println(result);

    }


}
