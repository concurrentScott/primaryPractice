package com.ddot.springbootdemo.concurrencypractice.test.sington;

import com.ddot.springbootdemo.concurrencypractice.annoation.NotRecommend;
import com.ddot.springbootdemo.concurrencypractice.annoation.Recommend;
import com.ddot.springbootdemo.concurrencypractice.annoation.ThreadSafe;

/**
 * 枚举模式
 */
@ThreadSafe
@Recommend
public class SingtonExam6 {
    private volatile static SingtonExam6 instance = null;

    private SingtonExam6(){

    }

    //性能开销过大
    public static  SingtonExam6 getInstance(){
        return Singleton.INSTANCE.getInstance();

    }
    private enum Singleton{
        INSTANCE;
        private SingtonExam6 singleton;

        /**jvm保证只调用一次，而且保证在调用的时候初始化*/
        Singleton(){
            singleton = new SingtonExam6();
        }

        public SingtonExam6 getInstance(){
            return singleton;
        }
    }



}
