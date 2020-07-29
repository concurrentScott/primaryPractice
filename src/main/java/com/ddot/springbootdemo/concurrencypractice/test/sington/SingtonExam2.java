package com.ddot.springbootdemo.concurrencypractice.test.sington;

import com.ddot.springbootdemo.concurrencypractice.annoation.NotThreadSafe;
import com.ddot.springbootdemo.concurrencypractice.annoation.ThreadSafe;

/**
 * 恶汉*/
@ThreadSafe
public class SingtonExam2 {
    private static SingtonExam2 instance = new SingtonExam2();

    private SingtonExam2(){

    }

    //静态工程方法
    public static SingtonExam2 getInstance(){


        return instance;
    }



}
