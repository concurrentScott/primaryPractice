package com.ddot.springbootdemo.concurrencypractice.test.commonunsafe;

import com.ddot.springbootdemo.concurrencypractice.annoation.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

@Slf4j
@NotThreadSafe
public class DataFormatExam1 {

    //请求总数
    public static final Integer clientTotal = 5000;
    //线程数量
    public static final Integer threadTotal = 200;

    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");


    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal); /**线程数小于信号量，则可以去掉，做线程控制*/
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal );

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
       // log.info("count:{}",count.get());


    }
    private static void add(){
        /**多线程访问*/
        try {
            simpleDateFormat.parse("20180208");
        } catch (ParseException e) {
            log.error("parse expection{}",e);
        }
        /**
         * 源码中使用了一个unsafe类
         */
    }

}
