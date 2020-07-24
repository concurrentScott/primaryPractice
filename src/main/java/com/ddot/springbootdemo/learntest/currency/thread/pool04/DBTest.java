package com.ddot.springbootdemo.learntest.currency.thread.pool04;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class DBTest {
    static DBPool pool = new DBPool(10);
    /*
    控制器 控制其他work线程先跑完后main线程才继续执行     */
    static CountDownLatch end;

    public static void main(String[] args) throws InterruptedException {
        //线程数量
        int threadCount = 50;
        end = new CountDownLatch(threadCount);
        int count = 20;//每个线程的操作次数  共有50*20此拿连接 放链接的操作
        AtomicInteger got = new AtomicInteger();//计数器 统计可以拿到连接的线程
        AtomicInteger notGot = new AtomicInteger();//计数器 统计没有拿到链接的线程 返回null
        for (int i = 0; i < threadCount; i++) {
            Thread thread = new Thread(new Worker(count, got, notGot),"work" + i);
            thread.start();
        }
        end.await();//main线程再此等待
        System.out.println("共尝试了" + threadCount * count);
        System.out.println("拿到连接数" + got);
        System.out.println("未能得到" + notGot);
    }
    static class Worker implements Runnable{
        int count;
        AtomicInteger got;
        AtomicInteger notGot;

        public Worker(int count, AtomicInteger got, AtomicInteger notGot) {
            this.count = count;
            this.got = got;
            this.notGot = notGot;
        }
        @Override
        public void run() {
            while (count > 0){
                //从连接池中去取连接 1000ms无法获取，将会返回null
                //分别统计获取的数量got和没获取的数量notgot
                try {
                    Connection connection = pool.fetchConnection((long) 1000);
                    if (connection != null){
                        try {
                            connection.createStatement();
                            connection.commit();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }finally {
                            pool.releaseConnection(connection);
                            got.incrementAndGet();
                        }
                    }else {
                        notGot.incrementAndGet();
                        System.out.println(Thread.currentThread().getName() + "等待超时");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    count--;
                }
            }
            end.countDown();

        }
    }
}
