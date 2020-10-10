package com.ddot.springbootdemo.concurrencypractice.test.commonunsafe;

import com.ddot.springbootdemo.concurrencypractice.annoation.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

@Slf4j
@NotThreadSafe
public class StringExample1 {

    //请求总数
    public static final Integer clientTotal = 5000;
    //线程数量
    public static final Integer threadTotal = 200;

    public static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal); /**线程数小于信号量，则可以去掉，做线程控制*/
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);

        for (int i = 0; i < clientTotal; i++) {
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    add();
                    semaphore.release();
                }catch (Exception e){
                    log.error("ex",e);
                }finally {
                    countDownLatch.countDown();
                }
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        log.info("size:{}",stringBuilder.length()); /**所有线程执行完成后执行该操作*/


    }
    /**这里是线程不安全的写法*/
    private static void add(){

        stringBuilder.append(1);
    }
}
