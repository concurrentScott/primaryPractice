package com.ddot.springbootdemo.learntest.currency.thread.atomic;

import java.util.concurrent.atomic.AtomicIntegerArray;

public class UserAtomicArray {

    static int[] value = {1,2};

    static AtomicIntegerArray ai = new AtomicIntegerArray(value);

    public static void main(String[] args) {
        ai.getAndSet(0,3);

        System.out.println(ai.get(0));

        System.out.println(value[0]); //原来数组不会发生变化
    }
}
