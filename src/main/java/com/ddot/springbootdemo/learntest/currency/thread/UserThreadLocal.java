package com.ddot.springbootdemo.learntest.currency.thread;

/**
 * threadlocal用法
 */
public class UserThreadLocal {

    static ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue() {
            return 1;
        }
    };

    /**
     * 运行三个线程
     */
    public void StartThreadArray(){
        Thread[] runs = new Thread[3];
        for (int i = 0; i < runs.length; i++) {
            runs[i] = new Thread(new TestThread(i));
        }
        for (int i = 0; i < runs.length; i++) {
            runs[i].start();
        }
    }
    public static class TestThread implements Runnable{
        int id;

        public TestThread(int id){
            this.id = id;
        }
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + ":start:" + threadLocal.get());
            Integer s = threadLocal.get();
            s = s + id;
            threadLocal.set(s);
            System.out.println(Thread.currentThread().getName() + ":" + threadLocal.get());
        }
    }

    public static void main(String[] args) {
        UserThreadLocal userThreadLocal = new UserThreadLocal();
        userThreadLocal.StartThreadArray();
    }

}
