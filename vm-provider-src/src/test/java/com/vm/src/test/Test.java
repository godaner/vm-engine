package com.vm.src.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.vm.base.util.CommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Created by ZhangKe on 2018/4/14.
 */
public class Test extends CommonUtil {
    private Logger logger = LoggerFactory.getLogger(Test.class);

    @org.junit.Test
    public void test() throws FileNotFoundException {
        System.out.println(JSONObject.toJSONString(new File("C:\\Users\\Administrator\\Desktop\\mp4\\05cacb4e02f9d9e.mp4")));
        logger.info(JSONObject.toJSONString(new FileInputStream(new File("C:\\Users\\Administrator\\Desktop\\mp4\\05cacb4e02f9d9e.mp4"))));
    }
}
