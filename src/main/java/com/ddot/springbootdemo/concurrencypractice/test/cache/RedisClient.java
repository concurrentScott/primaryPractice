package com.ddot.springbootdemo.concurrencypractice.test.cache;

import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;

@Component
public class RedisClient {

    @Resource(name = "redisPool")
    private JedisPool jedisPool;

    private void set(String key,String value)throws Exception{
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.set(key,value);
        }finally {
            if (jedis != null){
                jedis.close();
            }
        }

    }

}
