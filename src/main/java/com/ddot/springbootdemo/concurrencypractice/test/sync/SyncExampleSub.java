package com.ddot.springbootdemo.concurrencypractice.test.sync;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class SyncExampleSub extends SyncExample{

    public void test01(int j){
       super.test01(j);
    }
    public  void test02(int j){
        super.test02(j);
    }

    public static void main(String[] args) {
        SyncExampleSub syncExample = new SyncExampleSub();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> {
            syncExample.test02(1);
        });

        executorService.execute(() -> { /**模拟开启两个进程，能够实验差别*/
            syncExample.test02(2);
        });
    }
}
