package com.ddot.springbootdemo.concurrencypractice.test.lock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class LockExampl4 {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();

        Condition condition = lock.newCondition();

        new Thread(() -> {
            try {
                lock.lock();        /**加入等待队列中*/
                log.info("wait signal");
                condition.await();      /**从等待队列中移除，释放了锁，加入到condition的等待队列中*/
            }catch (Exception e){
                e.printStackTrace();
            }
            log.info("get signal");
            lock.unlock();
        }).start();

        new Thread(() -> {
            lock.lock();
            log.info("get lock");
            try {
                Thread.sleep(3000);
            }catch (Exception e){
                e.printStackTrace();
            }
            condition.signalAll();
            log.info("send signal");
            lock.unlock();  /**释放锁后，aqs队列中只剩线程1，线程一被唤醒*/
        }).start();

    }
}
