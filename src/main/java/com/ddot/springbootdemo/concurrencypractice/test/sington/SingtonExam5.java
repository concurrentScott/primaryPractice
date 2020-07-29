package com.ddot.springbootdemo.concurrencypractice.test.sington;

import com.ddot.springbootdemo.concurrencypractice.annoation.NotRecommend;
import com.ddot.springbootdemo.concurrencypractice.annoation.NotThreadSafe;
import com.ddot.springbootdemo.concurrencypractice.annoation.ThreadSafe;

/**
 * 恶汉*/
@ThreadSafe
@NotRecommend
public class SingtonExam5 {
    private volatile static SingtonExam5 instance = null;

    private SingtonExam5(){

    }

    //性能开销过大
    public static synchronized SingtonExam5 getInstance(){

        if (null == instance){      //双重检查机制
            synchronized (SingtonExam5.class){
                if (instance == null){
                    instance = new SingtonExam5();
                }
            }
        }

        return instance;
    }



}
