package com.ddot.springbootdemo.learntest.currency.thread.wn02;

/**
 * 测试notify notifyall
 */
public class TestWn {
    private static Express express = new Express(0,Express.CITY);

    private static class CheckKm extends Thread{
        @Override
        public void run() {
            express.waitKm();
        }
    }

    private static class CheckSite extends Thread{
        @Override
        public void run() {
            express.waitSite();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 3; i++) {     //三个线程监听里程数的变化
            new CheckKm().start();
        }
        for (int i = 0; i < 3; i++) {     //监听位置的变化
            new CheckSite().start();
        }
        Thread.sleep(1000);//主线程休眠
        express.changeSite();//主线程改变状态
    }
}
