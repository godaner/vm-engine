package com.vm.frontend.test;

import com.vm.base.util.CommonUtil;
import com.vm.redis.repository.inf.RedisRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTest {


    @Autowired
    private RedisRepository<String, Object> redisRepository;

    @Test
    public void testRedis() {
        redisRepository.hSet("1", "1", "1");

        CommonUtil.logger.info(redisRepository.hGet("1", "1").toString());
    }
}