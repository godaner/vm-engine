package com.vm.test.controller;

import com.vm.controller.UsersController;
import org.hamcrest.Matchers;
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
public class UsersControllerTest extends  BaseControllerTest{
    @Autowired
    private UsersController usersController;
    @Test
    public void test4(){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        String url = "http://localhost:"+port+"/users/a";
        Map<String, String> req = new HashMap<String, String>();
        String requestJson = "{...}";
        HttpEntity<String> entity = new HttpEntity<String>(requestJson,headers);
        String result = rt.postForObject(url, entity, String.class);
        System.out.println(result);

    }


}
