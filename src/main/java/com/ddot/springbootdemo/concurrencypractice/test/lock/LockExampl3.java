package com.ddot.springbootdemo.concurrencypractice.test.lock;

import com.ddot.springbootdemo.concurrencypractice.annoation.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@Slf4j
@ThreadSafe
public class LockExampl3 {

    private final static Map<String, Data>  map = new TreeMap<>();

    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    private final Lock readLock = lock.readLock();

    private final Lock writeLock = lock.writeLock();

    private Data get(String key){
        /**读请求 加读锁*/
        readLock.lock();
        try {
            return map.get(key);
        }finally {
            readLock.unlock();
        }

    }
    private Set<String> getAllKeys(){
        readLock.lock();
        try {
            return map.keySet();
        }finally {
            readLock.unlock();
        }
    }
    public Data put(String key,Data value){
        writeLock.lock();   //必须无读锁或者写锁读的时候才可以获取写锁子
        try {
            return map.put(key,value);
        }finally {
            writeLock.unlock();
        }
    }

    class Data{

    }

}
