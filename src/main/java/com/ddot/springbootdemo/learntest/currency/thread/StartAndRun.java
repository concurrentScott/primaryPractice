package com.ddot.springbootdemo.learntest.currency.thread;

public class StartAndRun {

    private static class ThreadRun extends Thread{
        public ThreadRun(String name){
            super(name);
        }

        @Override
        public void run() {
           int i = 90;
           while (i > 0){

           }
        }

        public static void main(String[] args) throws InterruptedException {
            //run方法谁调用就属于哪个线程 放入哪个方法的栈帧
            //在main方法中调用则放入主线程的栈帧中


        }
    }
}
