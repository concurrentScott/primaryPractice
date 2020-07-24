package com.ddot.springbootdemo.learntest.currency.lock.readwritelock;

import com.ddot.springbootdemo.learntest.currency.tools.SleepTools;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读多写少 可以使用读写锁 增加性能
 */

public class UserRwLock implements GoodsService
{

    private GoodsInfo goodsInfo;

    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    //读锁 写锁 分别获取
    private final Lock getLock = lock.readLock();

    private final Lock setLock = lock.writeLock();//写

    public UserRwLock(GoodsInfo goodsInfo){
        this.goodsInfo = goodsInfo;
    }

    @Override
    public GoodsInfo getNum() {
        getLock.lock();
        try {
            SleepTools.sm(5);
            return this.goodsInfo;

        }finally {
            getLock.unlock();
        }
    }

    @Override
    public void setNum(int num) {
        setLock.lock();
        try {
            SleepTools.sm(5);
            this.goodsInfo.changeNumber(num);
        }finally {
            setLock.unlock();
        }
    }
}
