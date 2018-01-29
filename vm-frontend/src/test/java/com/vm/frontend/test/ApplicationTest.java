package com.vm.frontend.test;

import com.vm.redis.repository.RedisRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTest {


    @Autowired
    private RedisRepository redisRepository;

    @Test
    public void testRedis() {

        redisRepository.hset("1", "1", 1000);

        redisRepository.hget("1", "1");

    }
}