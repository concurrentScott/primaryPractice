package com.ddot.springbootdemo.learntest.currency.lock.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ExpressCond {
    public final static String CITY = "Shanghai";
    private int km;
    private String site;

    private Lock kmLock = new ReentrantLock();
    private Lock siteLock = new ReentrantLock();

    private Condition kmCond = kmLock.newCondition();       //两个不同的队列
    private Condition siteCond = siteLock.newCondition();   //两个不同的队列 存放被await()的节点

    public ExpressCond(){

    }

    public ExpressCond(int km, String site) {
        this.km = km;
        this.site = site;
    }

    public void changeKm(){
        kmLock.lock();
        try {
            this.km = 101;
            kmCond.signal();    //尽量不使用signalAll两个锁对应两个不同变化 唤醒头节点
        }finally {
            kmLock.unlock();
        }
    }
    public void changeSite(){
        siteLock.lock();
        try {
            this.site = "beijing";
            siteCond.signal();
        }finally {
            siteLock.unlock();
        }
    }

    public void waitKm(){
        kmLock.lock();
        try {
            while (this.km <= 100){
                try {
                    kmCond.await(); //将当前节点的线程构造新的节点并加入等待队列
                    //表示被通知到 java中 notify只能通知一次 尽量使用notifyall
                    System.out.println("check km thread" + Thread.currentThread().getName() + "is be notified");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }finally {
            kmLock.unlock();
        }
        System.out.println("this Km is" + this.km + "change db");
    }
    public void waitSite(){
        siteLock.lock();
        try {
            while (this.site.equals(CITY)){
                try {
                    siteCond.await();
                    System.out.println("check site thread" + Thread.currentThread().getName() + "is be notified");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("the site is " + this.site + "i will change db.");

        }finally {
            siteLock.unlock();
        }

    }




    }
