package com.ddot.springbootdemo.concurrencypractice.test.sington;

import com.ddot.springbootdemo.concurrencypractice.annoation.NotRecommend;
import com.ddot.springbootdemo.concurrencypractice.annoation.ThreadSafe;

/**
 * 恶汉*/
@ThreadSafe
@NotRecommend
public class SingtonExam3 {
    private static SingtonExam3 instance = null;

    private SingtonExam3(){

    }

    //性能开销过大
    public static synchronized SingtonExam3 getInstance(){
        if (null == instance){
            instance = new SingtonExam3();
        }

        return instance;
    }



}
