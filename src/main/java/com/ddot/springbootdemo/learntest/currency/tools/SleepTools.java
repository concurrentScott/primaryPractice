package com.ddot.springbootdemo.learntest.currency.tools;

import java.util.concurrent.TimeUnit;

public class SleepTools {

    public static final void second(int seconds){
        /**
         * 按秒休眠
         */
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static final void sm(int seconds){
        /**
         * 按照毫米休眠
         */
        try {
            TimeUnit.MILLISECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    }
