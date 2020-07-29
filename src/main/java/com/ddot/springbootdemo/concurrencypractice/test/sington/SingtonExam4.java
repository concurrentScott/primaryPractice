package com.ddot.springbootdemo.concurrencypractice.test.sington;

import com.ddot.springbootdemo.concurrencypractice.annoation.NotRecommend;
import com.ddot.springbootdemo.concurrencypractice.annoation.NotThreadSafe;
import com.ddot.springbootdemo.concurrencypractice.annoation.ThreadSafe;

/**
 * 恶汉*/
@NotThreadSafe
@NotRecommend
public class SingtonExam4 {
    private static SingtonExam4 instance = null;

    private SingtonExam4(){

    }

    //性能开销过大
    public static synchronized SingtonExam4 getInstance(){

        if (null == instance){      //双重检查机制
            synchronized (SingtonExam4.class){
                if (instance == null){
                    instance = new SingtonExam4();
                }
            }
        }

        return instance;
    }



}
