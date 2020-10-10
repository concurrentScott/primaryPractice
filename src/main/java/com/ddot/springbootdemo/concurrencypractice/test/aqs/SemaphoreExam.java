package com.ddot.springbootdemo.concurrencypractice.test.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

@Slf4j
public class SemaphoreExam {
    private static int threadCount = 20;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();

        final Semaphore semaphore = new Semaphore(3);

        final CountDownLatch countDownLatch = new CountDownLatch(threadCount);

        for (int i = 0; i < threadCount; i++) {
            final int threadNum = i;
            exec.execute(() -> {

                try {
                    semaphore.acquire();
                    test(threadNum);
                    semaphore.release();
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
