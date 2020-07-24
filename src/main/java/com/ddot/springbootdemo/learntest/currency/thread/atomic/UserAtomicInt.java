package com.ddot.springbootdemo.learntest.currency.thread.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class UserAtomicInt {

    static AtomicInteger ai = new AtomicInteger(10);

    public static void main(String[] args) {
        System.out.println(ai.getAndIncrement());   //10
        System.out.println(ai.incrementAndGet());   //12
        System.out.println(ai.get());               //12
    }
}
