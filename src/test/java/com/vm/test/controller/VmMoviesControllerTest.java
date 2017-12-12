package com.vm.test.controller;

import com.vm.base.utils.PageBean;
import com.vm.dao.bo.VmMoviesQueryBean;
import org.junit.Test;
import org.springframework.http.HttpEntity;

/**
 * Created by ZhangKe on 2017/12/1.
 */
public class VmMoviesControllerTest extends BaseControllerTest{
    @Test
    public void getTagsGroupsWithTags(){

        String url = getLocalHost()+"/movie/list?start=0&size=10&orderBy=id&orderType=desc";
        String result = rt.getForObject(url,String.class);
        System.out.println(result);

    }


}
