package com.ddot.springbootdemo.learntest.currency.thread.sleep03;

/**
 * sleep不释放锁子
 */
public class SleepLock {
    private Object lock = new Object();

    public static void main(String[] args) {
        SleepLock sleepLock = new SleepLock();
        Thread thread1  = sleepLock.new ThreadSleep();
        thread1.setName("sleepthread");
        Thread thread2 = sleepLock.new ThreadNotSleep();
        thread2.setName("notsleepthread");
        thread1.start();

        //主线程休眠
        try {
            Thread.sleep(1000);
            System.out.println("主线程休眠");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread2.start();


    }
    private class ThreadSleep extends Thread{
        @Override
        public void run() {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + "将会拿到锁子");
            try {
                synchronized (lock){
                    System.out.println(threadName + "已经拿到锁子" + System.currentTimeMillis());
                    Thread.sleep(5000);

                    System.out.println(threadName + "已经完成工作");

                }
                //Thread.sleep(5000); 尽量将sleep放在持有锁的外面
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
    private class ThreadNotSleep extends Thread{
        @Override
        public void run() {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + "将会拿到锁子");
                synchronized (lock){
                    System.out.println(threadName + "已经拿到锁子" + System.currentTimeMillis());
                    System.out.println(threadName + "已经完成工作");

                }

        }
    }

    }
