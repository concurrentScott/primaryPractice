package com.ddot.springbootdemo.learntest.currency.thread.forkjoin.sum;


import com.ddot.springbootdemo.learntest.currency.tools.SleepTools;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class SumArray {
    private static class SumTask extends RecursiveTask<Integer> {//forkjointask子类


        //定义阈值
        private static final int THRESHODE = MakeArray.ARRAY_LENGTH / 10;
        private int[] src;  //需要计算的数组
        private int fromIndex;  //开始统计的下标
        private int toIndex;    //结束的下标

        public SumTask(int[] src, int fromIndex, int toIndex) {
            this.src = src;
            this.fromIndex = fromIndex;
            this.toIndex = toIndex;
        }

        /**
         * fork join 框架下的数组累加
         */
        @Override
        protected Integer compute() {
            if ((toIndex - fromIndex) < THRESHODE) {
                int count = 0;

                for (int i = fromIndex; i < toIndex; i++) {
                    SleepTools.sm(1);
                    count += src[i];
                }
                return count;

            } else {
                //拆分 fromindex mid toindex   递归
                //1.............70.....100  //随意切分
                int mid = (fromIndex + toIndex) / 2;
                //拆分为左右两个sumtask
                SumTask left = new SumTask(src, fromIndex, mid);
                SumTask right = new SumTask(src, mid + 1, toIndex);
                //使用invoke方法引入
                invokeAll(left,right);
                return left.join() + right.join();
            }
        }
    }

    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();
        int[] src = MakeArray.makeArray();
        SumTask innerFind = new SumTask(src, 0, src.length - 1);

        long start = System.currentTimeMillis();
        pool.invoke(innerFind);

        System.out.println("this count = " + innerFind.join() + ":时间" + (System.currentTimeMillis() - start) + "ms");

    }

}
