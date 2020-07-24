package com.ddot.springbootdemo.learntest.currency.thread;

public class HasInterrputException {

    private static class UserThread extends Thread {
        public UserThread(String name){
            super(name);
        }

        @Override
        public void run() {
            String threadname = Thread.currentThread().getName();

            while (!isInterrupted()){   //不属于中断状态，则继续工作
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    System.out.println(threadname + "interrupted flag is" + isInterrupted());
                    //抛出异常中断标志位为false不会中断 而是会抛出异常 需要手动关闭
                    //interrupt();
                    e.printStackTrace();
                }
            }
            System.out.println(threadname + "interrupted flag is" + isInterrupted());

        }

        public static void main(String[] args) throws InterruptedException {
            Thread endThread = new UserThread("hasexcp");
            endThread.start();
            Thread.sleep(20); //主线程休眠
            endThread.interrupt();  //不是强制中断
            // 这样设计能够响应中断

        }
    }
}

