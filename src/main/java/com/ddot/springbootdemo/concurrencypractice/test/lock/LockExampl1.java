package com.ddot.springbootdemo.concurrencypractice.test.count;

import com.ddot.springbootdemo.concurrencypractice.annoation.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.LongAdder;

@Slf4j
@ThreadSafe
public class LockExampl1 {

    //请求总数
    public static final Integer clientTotal = 5000;
    //线程数量
    public static final Integer threadTotal = 200;

    public static volatile Integer count = 0;

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
        // countDownLatch.await();
        executorService.shutdown();
        log.info("count:{}",count   );


    }
    /**这里是线程不安全的写法*/
    private static void add(){
        count++;

        //1，取出count值
        //2，加一 写回去
        //3，count
    }
}
