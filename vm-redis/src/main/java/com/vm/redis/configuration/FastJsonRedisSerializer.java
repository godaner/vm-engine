package com.vm.redis.configuration;

import com.alibaba.fastjson.JSON;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

import java.nio.charset.Charset;

/**
 * 使用fastjson实现自己的序列化/反序列
 * 这里有限制，不能使用
 *
 * @author lsj <lishuijun1992@gmail.com>
 * @date 17-4-19
 */
public class FastJsonRedisSerializer<T> implements RedisSerializer<T> {

    private static final Charset charset = Charset.forName("UTF-8");

    private Class clazz;

    public FastJsonRedisSerializer(Class clazz) {
        this.clazz = clazz;
    }

    public FastJsonRedisSerializer() {
    }

    /**
     * 序列化
     *
     * @param t
     * @return
     * @throws SerializationException
     */
    public byte[] serialize(T t) throws SerializationException {
        if (t == null) {
            return new byte[0];
        }
        return JSON.toJSONString(t).getBytes(charset);//这里可以根据需要选择相应的方法
    }


    /**
     * 反序列化
     *
     * @param bytes
     * @return
     * @throws SerializationException
     */
    public T deserialize(byte[] bytes) throws SerializationException {
        if (bytes == null || bytes.length <= 0) {
            return null;
        }
        String str = new String(bytes, charset);
        if (clazz == null) {
            return (T) JSON.parse(str);
        }
        return (T) JSON.parseObject(str, clazz);
    }
}