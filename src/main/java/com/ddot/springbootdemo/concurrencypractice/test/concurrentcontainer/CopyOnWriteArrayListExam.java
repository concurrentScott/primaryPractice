package com.ddot.springbootdemo.concurrencypractice.test.concurrentcontainer;

import lombok.extern.slf4j.Slf4j;

import java.security.Signature;
import java.util.List;
import java.util.concurrent.*;

@Slf4j
public class CopyOnWriteArrayListExam {

    public final static  int threadTotal = 5000;
    public final static  int clientTotal = 200;

    public final static List<Integer> list = new CopyOnWriteArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        final Semaphore semaphore = new Semaphore(clientTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(threadTotal);

        final ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < threadTotal; i++) {
            final int temp = i;
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    add(temp);
                    semaphore.release();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    countDownLatch.countDown();
                }
            });
        }
        countDownLatch.await();
        log.info("list的长度{}",list.size());


    }
    public static void add(int i){
        list.add(i);

    }

}
