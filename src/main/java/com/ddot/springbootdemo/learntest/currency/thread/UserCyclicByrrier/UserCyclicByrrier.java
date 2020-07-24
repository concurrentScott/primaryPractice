package com.ddot.springbootdemo.learntest.currency.thread.UserCyclicByrrier;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CyclicBarrier;

/**
 * cycbarrier到使用
 */
public class UserCyclicByrrier {

    private static CyclicBarrier barrier = new CyclicBarrier(5,new CollectThread());

    private static ConcurrentHashMap<String,Long> resultMap =
            new ConcurrentHashMap<>();//存放子工作线程到容器

    public static void main(String[] args) {
        for (int i = 0; i < 4; i++) {
            Thread thread = new Thread(new SubThread());
            thread.start();
        }
    }

    //负责屏障开放以后等工作  专门由一个线程来完成
    private static class CollectThread implements Runnable{

        @Override
        public void run() {
            StringBuilder result = new StringBuilder();
            for (Map.Entry<String, Long> workResult : resultMap.entrySet()) {
                result.append("{" + workResult.getValue()+"}");
            }
            System.out.println("result" + result);
            System.out.println("do other business");
        }
    }
    //工作线程
    private static class SubThread implements Runnable{
        @Override
        public void run() {

            //把id放进结果里面
            long id = Thread.currentThread().getId();
            resultMap.put(Thread.currentThread().getId()+ "",id);
            Random random = new Random();

            try {
                if (random.nextBoolean()){
                    Thread.sleep(1000 + id);
                    System.out.println("thread" + id + "do something");
                }
                System.out.println(id + "is await");
                barrier.await();    //所有线程都在这里等待 ，等执行相同方法等睡眠中等其他线程 都唤醒了菜接着执行
                Thread.sleep(1000 + id);
                System.out.println("thread" + id + "do something");

            } catch (Exception e) {
                e.printStackTrace();
            }


        }
    }
}
