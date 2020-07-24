package com.ddot.springbootdemo.learntest.currency.lock.locktest1;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * 使用显示锁的范式，必须try finally释放锁
 *
 * 超时获取 尝试获取锁 用lock  公平锁和非公平锁
 *
 * 递归时候 需要可重入锁
 *
 * 非公平锁 效率高
 *
 * reentrantlock 和syn 都是排他锁
 */
public class LockDemo {

    private Lock lock = new ReentrantLock();
    private int count;

    public void increment(){
        lock.lock();
        try {
            count++;
        }finally {
            lock.unlock();
        }
    }

    public synchronized void increment2(){

    }

}
