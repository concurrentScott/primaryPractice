package com.ddot.springbootdemo.concurrencypractice.test.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

@Slf4j
public class CyclicBarrierExam3 {

    final static CyclicBarrier barrier = new CyclicBarrier(5,() -> {
        log.info("callback is running ");
    });

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < 10; i++) {
            final int threadNum = i;

            Thread.sleep(1000);
            executorService.execute(() -> {
                try {
                    race(threadNum);
                } catch (Exception e) {
                    log.error("ex",e);
                }


            });

        }
    }

    public static void race(int threadNum)throws Exception{
        Thread.sleep(1000);
        log.info("{} is ready",threadNum);
        try {
            barrier.await(); //
        }catch (BrokenBarrierException e){  //需要捕捉后面的异常，使进度继续执行下去，保证后续代码的执行
            log.error("brokenbarrierException");
        }
        log.info("{} continue",threadNum);


    }
}
