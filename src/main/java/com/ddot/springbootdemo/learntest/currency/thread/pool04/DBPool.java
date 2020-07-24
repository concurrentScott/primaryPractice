package com.ddot.springbootdemo.learntest.currency.thread.pool04;

import java.sql.Connection;
import java.util.LinkedList;

/**
 * 实现一个数据库连接池
 */
public class DBPool {
    //连接容器
    private static LinkedList<Connection> pool = new LinkedList<>();
    //初始化大小
    public DBPool(int initalSize){
        if (initalSize > 0){
            for (int i = 0; i < initalSize; i++) {
                pool.addLast(SqlConnectImpl.fetchConnection());
            }
        }
    }
    //从池中拿连接 mills时间内拿不到则返回null
    public Connection fetchConnection(Long mills) throws InterruptedException {
        synchronized (pool){
            if (mills < 0){
                while (pool.isEmpty()){
                    pool.wait();
                }
                return pool.removeFirst();
            }else {
                long overTime = System.currentTimeMillis() + mills;
                long remain = mills;
                while (pool.isEmpty() && remain > 0){
                    pool.wait(remain);
                    remain = overTime - System.currentTimeMillis();
                }
                Connection result = null;
                if (!pool.isEmpty()){
                    result = pool.removeFirst();
                }
                return result;
            }
        }

    }
    public void releaseConnection(Connection connection){
        if (null != connection){
            synchronized (pool){
                pool.addLast(connection);
                pool.notifyAll();   //通知等待的线程有连接可以拿了
            }
        }
    }

}
