package com.ddot.springbootdemo.learntest.currency.test;

import com.ddot.springbootdemo.TestReflection.User;

public class ThreadTest {

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
    }


    public User getUser(){
        return new User(Thread.currentThread().getName(),Thread.currentThread().getName(),20);
    }

}
