package com.vm.base.util;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by ZhangKe on 2018/4/10.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles(profiles = "dev")
public class VmServiceBaseUnitTest extends CommonUtil {
    protected final static Logger logger = LoggerFactory.getLogger(VmServiceBaseUnitTest.class);

    protected final static void print(Object obj) {
        logger.info("====>>>>Unit test response is : {} ! ", obj2SimpleJSONString(obj));
    }
}
