package com.ddot.springbootdemo.concurrencypractice.test.cache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j
public class GuavaCacheExample {

    public static void main(String[] args) {

        LoadingCache<String,Integer> cache = CacheBuilder.newBuilder()
                .maximumSize(10)
                .expireAfterWrite(10, TimeUnit.SECONDS)
                .recordStats()  //开启记录状态数据功能
                .build(new CacheLoader<String, Integer>() {
                    @Override
                    public Integer load(String key) throws Exception {
                        //若过期，可以在这里加载数据的值
                        return -1;
                    }
                });

        log.info("{}",cache.getIfPresent("key1"));//null
        cache.put("key1",1);
        log.info("{}",cache.getIfPresent("key1"));//1
        cache.invalidate("key1");
        log.info("{}",cache.getIfPresent("key1"));//null

        try {
            log.info("{}",cache.get("key2"));//-1

            cache.put("key2",2);

            log.info("{}",cache.size());//1

            for (int i = 3; i < 13; i++) {
                cache.put("key" + i,i);
            }
            log.info("{}",cache.size());//10

            log.info("{}",cache.getIfPresent("key2"));//null

            Thread.sleep(11000);

            log.info("{}",cache.get("key5")); //-1

            log.info("{},{}",cache.stats().hitCount(),cache.stats().missCount());
            log.info("{},{}",cache.stats().hitRate(),cache.stats().missRate());

        }catch (Exception e){

        }

    }
}
