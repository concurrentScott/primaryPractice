package com.ddot.springbootdemo.learntest.currency.thread;

public class EndRunnable {

    private static class UserRunnable implements Runnable {

        @Override
        public void run() {
            String threadname = Thread.currentThread().getName();

            while (!Thread.currentThread().isInterrupted()){   //不属于中断状态，则继续工作
                System.out.println(threadname + "is running");
            }
            System.out.println(threadname + "interrupted flag is" + Thread.currentThread().isInterrupted());
        }

        public static void main(String[] args) throws InterruptedException {
            UserRunnable endrunnable = new UserRunnable();
            Thread runthread = new Thread(endrunnable);
            runthread.start();
            Thread.sleep(20); //主线程休眠
            runthread.interrupt();

        }
    }
}

