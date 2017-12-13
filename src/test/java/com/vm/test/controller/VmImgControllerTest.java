package com.vm.test.controller;

import org.junit.Test;

/**
 * Created by ZhangKe on 2017/12/1.
 */
public class VmImgControllerTest extends BaseControllerTest{
    @Test
    public void getImg(){
        String url = getLocalHost()+"/img/aa.png";
        String result = rt.getForObject(url, String.class);
        System.out.println(result);

    }


}
