package com.ddot.springbootdemo.java8.forkjoin;


import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

public class Test01 {

    @org.junit.Test
    public void test01(){
        ForkJoinPool pool = new ForkJoinPool();

        ForkJoinTask<Long> forkJoinTask = new ForkJoinTest(0,10000000L);
        Long sum = pool.invoke(forkJoinTask);
        System.out.println(sum);
    }

}
