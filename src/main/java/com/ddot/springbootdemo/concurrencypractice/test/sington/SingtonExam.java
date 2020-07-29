package com.ddot.springbootdemo.concurrencypractice.test.sington;

import com.ddot.springbootdemo.concurrencypractice.annoation.NotThreadSafe;

/**
 * 懒汉式*/
@NotThreadSafe
public class SingtonExam {
    private static SingtonExam instance = null;

    private SingtonExam(){

    }

    //静态工程方法
    public static SingtonExam getInstance(){
        if (instance == null){
            instance =  new SingtonExam();
        }
        return instance;
    }



}
