package com.ddot.springbootdemo.concurrencypractice.test.executorpool;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class ThreadPoolExample3 {

    public static void main(String[] args) {
        /**一个线程按顺序执行下来*/
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        for (int i = 0; i < 10; i++) {
            final  int index = i;
            executorService.execute(() -> {
                log.info("task{}",index);
            });

        }
        executorService.shutdown(); 
    }

}
