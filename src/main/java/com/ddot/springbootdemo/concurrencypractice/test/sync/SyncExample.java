package com.ddot.springbootdemo.concurrencypractice.test.sync;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class SyncExample {

    public void test01(int j){
        synchronized (this){
            for (int i = 0; i < 10; i++) {
                log.info("test1:{} -{}",i,j);
            }
        }
    }
    public synchronized void test02(int j){
        for (int i = 0; i < 10; i++) {

            log.info("test2:{} - {}",i,j);
        }
    }

    public static void main(String[] args) {
        SyncExample syncExample = new SyncExample();
        SyncExample syncExample1 = new SyncExample();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> {
            syncExample.test02(1);
        });

        executorService.execute(() -> { /**模拟开启两个进程，能够实验差别*/
            syncExample1.test02(2);
        });
    }
}
