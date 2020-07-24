package com.ddot.springbootdemo.learntest.currency.thread;

public class EndThread {

    private static class UserThread extends Thread{
        public UserThread(String name){
            super(name);
        }

        @Override
        public void run() {
            String threadname = Thread.currentThread().getName();

            //isInterrupted方法是Thread类的方法
            while (!isInterrupted()){   //不属于中断状态，则继续工作
                System.out.println(threadname + "is running");
            }
            System.out.println(threadname + "interrupted flag is" + isInterrupted());
        }

        public static void main(String[] args) throws InterruptedException {
            Thread endThread = new UserThread("endthread");
            endThread.start();
            Thread.sleep(20); //主线程休眠
            endThread.interrupt();  //不是强制中断 协作中断


        }
    }
}
