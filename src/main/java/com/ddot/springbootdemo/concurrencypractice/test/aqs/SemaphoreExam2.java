package com.ddot.springbootdemo.concurrencypractice.test.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

@Slf4j
public class SemaphoreExam2 {
    private static int threadCount = 20;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();

        final Semaphore semaphore = new Semaphore(3);

        final CountDownLatch countDownLatch = new CountDownLatch(threadCount);

        for (int i = 0; i < threadCount; i++) {
            final int threadNum = i;
            exec.execute(() -> {

                try {
                    semaphore.acquire(3);   //一次拿到3个许可，不能在获取了，相当于串行执行
                    test(threadNum);
                    semaphore.release(3);
                } catch (InterruptedException e) {
                    log.error("error {}",e);
                }finally {
                    countDownLatch.countDown();
                }

            });
        }
        countDownLatch.await();
        log.info("finish");
        exec.shutdown();

    }

    private static void test(int threadNum) throws InterruptedException {

        Thread.sleep(100);
        log.info("{}",threadNum);
        Thread.sleep(100);


    }
}
