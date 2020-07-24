package com.ddot.springbootdemo.learntest.currency.lock.aqs.template.aqsimpl;

import com.ddot.springbootdemo.learntest.currency.tools.SleepTools;

import java.util.concurrent.locks.Lock;

public class TestMyLock {
    public void test(){
        final Lock lock = new SelfLock();

        class Worker extends Thread{
            @Override
            public void run() {
                while (true){
                    lock.lock();  //只允许一个线程执行这个system.out.println方法
                                    // 虽然开了5个线程 但是都要去争抢同一个锁子
                    try {
                        SleepTools.second(1);
                        //System.out.println(Thread.currentThread().getId() + "***");
                        System.out.println(1);
                        SleepTools.second(1);
                    }finally {
                        lock.unlock();
                    }
                    SleepTools.second(2);
                }
            }
        }
        for (int i = 0; i < 10; i++) {
            Worker w = new Worker();;
            w.setDaemon(true);
            w.start();
        }

        //主线程每一秒换一次行
        for (int i = 0; i < 10; i++) {
            SleepTools.second(1);
            System.out.println( " " + Thread.currentThread() );
        }
    }

    public static void main(String[] args) {
        TestMyLock testMyLock =  new TestMyLock();
        testMyLock.test();
    }
}
