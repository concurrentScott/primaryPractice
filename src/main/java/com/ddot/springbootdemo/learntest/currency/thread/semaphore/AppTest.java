package com.ddot.springbootdemo.learntest.currency.thread.semaphore;

import com.ddot.springbootdemo.learntest.currency.tools.SleepTools;

import java.sql.Connection;
import java.util.Random;

public class AppTest {

    private static DBPoolSemaphore dbPool = new DBPoolSemaphore();

    //业务线程
    private static class BusiThread extends Thread{
        @Override
        public void run() {
            Random r = new Random();    //让每个线程持有的连接数不一样
            long start = System.currentTimeMillis();

            try {
                Connection connection = dbPool.takeConnection();
                System.out.println("Thread" + Thread.currentThread().getId() +
                        "获取连接数总耗时" + (System.currentTimeMillis() - start) + "ms" );
                SleepTools.sm(100 * r.nextInt(100));    //模拟业务操作 查询数据
                System.out.println("查询数据完成");
                dbPool.returnConnect(connection);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 50; i++) {
            new BusiThread().start();

        }
    }
}
