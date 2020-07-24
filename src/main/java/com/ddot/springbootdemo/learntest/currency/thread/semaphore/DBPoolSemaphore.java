package com.ddot.springbootdemo.learntest.currency.thread.semaphore;

import java.sql.Connection;
import java.util.LinkedList;
import java.util.concurrent.Semaphore;

/**
 *
 * 使用semaphore 实现一个数据库连接
 */
public class DBPoolSemaphore {
    private final static int POOL_SIZE = 10;
    private final Semaphore useful,useless;    //useful表示可用的连接 useless表示已经用的连接

    public DBPoolSemaphore(){
        this.useful = new Semaphore(POOL_SIZE);
        this.useless = new Semaphore(0);

    }

    //存放数据库连接
    private static LinkedList<Connection > pool = new LinkedList<>();

    //初始状态
    static {
        for (int i = 0; i < POOL_SIZE; i++) {
            pool.addLast(SqlConnectionImpl.fetchConnection());

        }
    }
    public void returnConnect(Connection connection) throws InterruptedException {
        if (connection != null){
            System.out.println("当前有 + " + useful.getQueueLength() + "个线程等待数据库连接" +
                    "可用连接数:" + useful.availablePermits());
            useless.acquire();
            synchronized (pool){
                pool.addLast(connection);
            }
            useful.release();
        }

    }

    public Connection takeConnection() throws InterruptedException {
        useful.acquire();
        Connection conn ;
        synchronized (pool){
            conn = pool.removeFirst();
        }

        useless.release();
        return conn;

    }


}
