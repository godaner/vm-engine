package com.vm.test.controller;

import org.junit.Test;

/**
 * Created by ZhangKe on 2017/12/1.
 */
public class VmMoviesControllerTest extends BaseControllerTest{
    @Test
    public void getMovies(){

        String url = getLocalHost()+"/movie/list?start=0&size=10&orderBy=watch_num&orderType=desc";
        String result = rt.getForObject(url,String.class);
        System.out.println(result);

    }


}
