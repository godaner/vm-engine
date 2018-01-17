package com.vm.redis.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;

/**
 * @author lsj <lishuijun1992@gmail.com>
 * @date 17-4-19
 */
@Configuration
public class RedisTemplateConfig {

    @Autowired
    private JedisConnectionFactory jedisConnectionFactory;

    /**
     * 注入Jackson2JsonRedisSerializer作为默认的序列化方式
     *
     * @param objectMapper
     * @return
     */
    @Bean
    public RedisSerializer jackson2JsonRedisSerializer(ObjectMapper objectMapper) {
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        jackson2JsonRedisSerializer.setObjectMapper(objectMapper);
        return new Jackson2JsonRedisSerializer(Object.class);
    }

    /**
     * 可以自己进行注入或者不注入
     *
     * @return
     */
    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper;
    }

    /**
     * 自定义注入RedisTemplate
     *
     * @param redisSerializer
     * @return
     */
    @Bean
    public RedisTemplate redisTemplate(RedisSerializer redisSerializer) {
        StringRedisTemplate redisTemplate = new StringRedisTemplate(jedisConnectionFactory);
        redisTemplate.setValueSerializer(redisSerializer);
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }
}