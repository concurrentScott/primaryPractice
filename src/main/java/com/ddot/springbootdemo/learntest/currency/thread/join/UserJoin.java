package com.ddot.springbootdemo.learntest.currency.thread.join;


import com.ddot.springbootdemo.learntest.currency.tools.SleepTools;

public class UserJoin {

    static class JumpQueue implements Runnable{
        private Thread thread;  //用来插队的线程

        public JumpQueue(Thread thread){
            this.thread = thread;
        }
        @Override
        public void run() {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(thread.currentThread().getName() + "结束");
        }
    }

    public static void main(String[] args) {
        Thread previous = Thread.currentThread();   //一开始是主线程
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new JumpQueue(previous),String.valueOf(i));
            System.out.println(previous.getName() + "跳到前面" + thread.getName());
            thread.start();

            previous = thread;

        }
        SleepTools.second(2);//主线程休息两秒
        //最后一个线程等其他所以线程都执行完才执行

        System.out.println(Thread.currentThread().getName() + "结束");
    }

}
