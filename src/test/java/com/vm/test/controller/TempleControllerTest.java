package com.vm.test.controller;

import com.google.common.collect.ImmutableMap;
import org.junit.Test;
import org.springframework.http.HttpEntity;

/**
 * Created by ZhangKe on 2017/12/1.
 */
public class TempleControllerTest extends BaseControllerTest{
    @Test
    public void a(){

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
