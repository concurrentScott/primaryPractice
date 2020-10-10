package com.ddot.springbootdemo.concurrencypractice.test.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

@Slf4j
public class SemaphoreExam3 {
    private static int threadCount = 20;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();

        final Semaphore semaphore = new Semaphore(10);

        final CountDownLatch countDownLatch = new CountDownLatch(threadCount);

        for (int i = 0; i < threadCount; i++) {
            final int threadNum = i;
            exec.execute(() -> {

                try {
                    if(semaphore.tryAcquire()){         //尝试获取一个许可，获取不到的线程丢弃，一口气获取
                    //if (semaphore.tryAcquire(1, TimeUnit.SECONDS))   停秒，秒数内可获取的能执行，获取不到则放弃
                        test(threadNum);
                        semaphore.release(3);
                    }

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
