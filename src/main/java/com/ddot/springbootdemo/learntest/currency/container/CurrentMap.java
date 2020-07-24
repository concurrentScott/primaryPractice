package com.ddot.springbootdemo.learntest.currency.container;

import java.util.concurrent.ConcurrentHashMap;

public class CurrentMap {
    public static void main(String[] args) {
        ConcurrentHashMap<String,String> map =
                new ConcurrentHashMap<>();
        map.put("001","v1");
        map.put("002","v2");
        map.put("003","v3");
        System.out.println("*****");

        System.out.println("002="  + map.get("002"));

    }

    /*//复合操作需要加锁
    public T putIfAbse(){
        synchronized (this){
            result = get();
            if (result == null){
                put();
            }else {
                return result;
            }
        }
    }*/


}
