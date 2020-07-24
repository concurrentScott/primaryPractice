package com.ddot.springbootdemo.java8.forkjoin;

import java.util.concurrent.RecursiveTask;

public class ForkJoinTest extends RecursiveTask<Long> {

    private long start;
    private long end;

    public ForkJoinTest(long start, long end) {
        this.start = start;
        this.end = end;
    }

    private static final long THREADHOLD = 10000;
    @Override
    protected Long compute() {
        long length  = end - start;
        if (length <= THREADHOLD){
            long sum = 0;
            for (long i = start; i <= end ; i++) {
                sum += i;
            }
            return sum;
        }else {
            long mid = (start + end) / 2;
            ForkJoinTest left = new ForkJoinTest(start,mid);
            left.fork();    //拆分子任务，同时押入线程队列

            ForkJoinTest right = new ForkJoinTest(mid,end);
            right.fork();

            return left.join() + right.join();
        }
    }


}
