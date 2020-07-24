package com.ddot.springbootdemo.learntest.currency.container;

import java.util.concurrent.ConcurrentHashMap;

public class TestMap {

    public static void main(String[] args) {
        ConcurrentHashMap<String,String> map = new ConcurrentHashMap<>();
        map.put("mark","mark");
        map.get("bill");

        int c = 43;
        int n = c - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        n = n + 1;
        System.out.println("n=" + n);



    }
}
