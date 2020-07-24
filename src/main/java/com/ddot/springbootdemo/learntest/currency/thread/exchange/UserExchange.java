package com.ddot.springbootdemo.learntest.currency.thread.exchange;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Exchanger;

public class UserExchange {
    private static final Exchanger<Set<String>> exchange = new Exchanger<>();

    public static void main(String[] args) {
        //第一个线程
        new Thread(() ->{
            Set<String> setA = new HashSet<>(); //存放数据的容器

            try {
                setA = exchange.exchange(setA); //交换setA
                /*
                处理交换后的数据
                 */
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        //第二个线程
        new Thread(() -> {
            Set<String> setB = new HashSet<>();
            try {

                setB = exchange.exchange(setB); //只能两个线程之间进行数据交换
            }catch (Exception e){

            }
        }).start();

    }
}
