package com.ddot.springbootdemo.learntest.currency.thread.forkjoin.sum;


import com.ddot.springbootdemo.learntest.currency.tools.SleepTools;

public class SumNormal {
    /**
     * 单线程完成数组的累加
     */
    public static void main(String[] args) {
        int count = 0;
        int[] src = MakeArray.makeArray();
        long start = System.currentTimeMillis();
        for (int i = 0; i < src.length; i++) {
            SleepTools.sm(1);
             count += src[i];
        }
        System.out.println("count=" + count + "::" + (System.currentTimeMillis() - start) + "ms");

    }
}
