package com.ddot.springbootdemo.learntest.currency.thread.countdownlatch;

import com.ddot.springbootdemo.learntest.currency.tools.SleepTools;

import java.util.concurrent.CountDownLatch;

/**
 * countdownlatch用法 有5个初始化线程 有6个扣除点
 *
 * 扣除完毕 主线程业务线程继续工作
 */
public class UserCountDownLatch {

    static CountDownLatch latch = new CountDownLatch(5);
    //初始化线程
    private static class InitThread implements Runnable{
        @Override
        public void run() {
            System.out.println("thread" + Thread.currentThread().getId() + "ready inin work");

            latch.countDown(); //初始化线程完成工作
            for (int i = 0; i < 2; i++) {
                System.out.println("thread" + Thread.currentThread().getId() + "continue to work");
            }
        }
    }

    //业务线程
    private static class BusinessThread implements Runnable{
        @Override
        public void run() {
            try {
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < 3; i++) {
                System.out.println("thread bus" + Thread.currentThread().getId() + "continue to work");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        //单独对初始化线程
        new Thread(() -> {
            SleepTools.sm(1);
            System.out.println("thread" + Thread.currentThread().getId() + "ready init step 1st");

            latch.countDown();

            System.out.println("thread" + Thread.currentThread().getId() + "begin step 2nd");
            System.out.println("thread" + Thread.currentThread().getId() + "ready init step 2nd");

            latch.countDown();
        }).start();

        new Thread(new BusinessThread()).start();
        for (int i = 0; i < 3; i++) {
             new Thread(new InitThread()).start();
        }


        latch.await();   //那个线程使用这个方法 哪个线程等到count=0到时候执行自己到业务方法

        System.out.println("main do ites work");

    }




    }
