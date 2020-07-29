package com.ddot.springbootdemo.concurrencypractice.test.sington;

import com.ddot.springbootdemo.concurrencypractice.annoation.NotRecommend;
import com.ddot.springbootdemo.concurrencypractice.annoation.ThreadSafe;

/**
 * 恶汉*/
@ThreadSafe
@NotRecommend
public class SingtonExam6 {
    private volatile static SingtonExam6 instance = null;

    private SingtonExam6(){

    }

    //性能开销过大
    public static synchronized SingtonExam6 getInstance(){

        if (null == instance){      //双重检查机制
            synchronized (SingtonExam6.class){
                if (instance == null){
                    instance = new SingtonExam6();
                }
            }
        }

        return instance;
    }



}
