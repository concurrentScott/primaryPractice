package com.ddot.springbootdemo.concurrencypractice.test.threadlocal;

public class RequestHolder {

    /**一个请求从开始到结束（同一个线程）都可以直接从threadLocal中获取当前登陆的用户信息*/
    private final static ThreadLocal<Long> requestHolder = new ThreadLocal<>();

    /**请求到后端服务器，没有实际处理的时候调用*/
    public static void add(Long id){
        requestHolder.set(id); /**key是当前线程的变量 ，value值为id*/
    }

    public static Long getId(){
        return requestHolder.get();
    }

    /**要移除信息，不然会造成内存泄漏，内存无法去掉*/
    public static void remove(){
        requestHolder.remove();
    }
}
