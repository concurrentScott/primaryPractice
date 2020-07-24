package com.ddot.springbootdemo.learntest.currency.lock.readwritelock;

import com.ddot.springbootdemo.learntest.currency.tools.SleepTools;

import java.util.Random;

public class BusiApp {

    static final int readWriteRatio = 10; //读写的比例
    static final int minThreadCount = 3;    //最小线程数
    //static CountDownLatch countDownLatch = new CountDownLatch(1);

    //读操作
    private static class GetThread implements Runnable{
        private GoodsService goodsService;

        public GetThread(GoodsService goodsService) {
            this.goodsService = goodsService;
        }
        @Override
        public void run() {

            Long start = System.currentTimeMillis();
            for (int i = 0; i < 100; i++) {
                goodsService.getNum();
            }
            System.out.println(Thread.currentThread().getName() +
                    "读商品耗时" + (System.currentTimeMillis() - start));

        }
    }
    private static class SetThread implements Runnable{
        private GoodsService goodsService;

        public SetThread(GoodsService goodsService) {
            this.goodsService = goodsService;
        }
        @Override
        public void run() {

            Long start = System.currentTimeMillis();
            Random random = new Random();
            for (int i = 0; i < 10; i++) {
                SleepTools.sm(50);
                goodsService.setNum(random.nextInt(10));
            }
            System.out.println(Thread.currentThread().getName() +
                    "写商品耗时" + (System.currentTimeMillis() - start));

        }
    }

    public static void main(String[] args) {
            GoodsInfo goodsInfo = new GoodsInfo("cup",100000,10000);
            GoodsService goodsService = new UseSyn(goodsInfo);
        for (int i = 0; i < minThreadCount; i++) {
            Thread setThread = new Thread(new SetThread(goodsService));
            for (int i1 = 0; i1 < readWriteRatio; i1++) {
                Thread getThread = new Thread(new GetThread(goodsService));
                getThread.start();
            }
            SleepTools.sm(100);
            setThread.start();
        }
    }
}
