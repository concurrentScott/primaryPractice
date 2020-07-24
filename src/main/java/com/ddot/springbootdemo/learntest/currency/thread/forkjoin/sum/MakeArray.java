package com.ddot.springbootdemo.learntest.currency.thread.forkjoin.sum;

import java.util.Random;

/**
 * 产生整型数组工具类
 */
public class MakeArray {
    //数组长度
    public static final int ARRAY_LENGTH = 4000;

    public static int[] makeArray(){
        //随机数发生器
        Random random = new Random();
        int[] result = new int[ARRAY_LENGTH];

        //填充数组
        for (int i = 0; i < ARRAY_LENGTH; i++) {
            result[i] = random.nextInt(ARRAY_LENGTH * 3);

        }
        return result;

    }

}
