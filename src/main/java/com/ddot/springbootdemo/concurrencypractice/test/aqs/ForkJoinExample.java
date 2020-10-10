package com.ddot.springbootdemo.concurrencypractice.test.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RecursiveTask;

@Slf4j
public class ForkJoinExample extends RecursiveTask<Integer> {
    public static final int threshold = 2;
    private int start;
    private int end;

    public ForkJoinExample(int start,int end){
        this.start = start;
        this.end = end;
    }


    @Override
    protected Integer compute() {
        int sum = 0;
        /**如果任务小就直接执行任务*/

        boolean canCampute = (end - start) <= threshold;
        if (canCampute){
            for (int i = start; i <= end ; i++) {
                sum += i;
            }
        }else {
            /**任务较大，分成两个执行*/
            int mid = (start + end) / 2;
            ForkJoinExample leftTask = new ForkJoinExample(start,mid);
            ForkJoinExample rightTask = new ForkJoinExample(mid + 1,end);

            /**执行子任务*/
            leftTask.fork();
            rightTask.fork();

            sum = leftTask.join() + rightTask.join();
        }
        return sum;
    }

    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();

        //生成一个计算任务
        ForkJoinExample task = new ForkJoinExample(1,100);

        /**执行任务*/
        Future<Integer> res = forkJoinPool.submit(task);

        try {
            log.info("result = {}",res.get());
        }catch (Exception e){
            log.error("ex",e);
        }

    }
}
