package com.ddot.springbootdemo.learntest.currency.thread.future;

import com.ddot.springbootdemo.learntest.currency.tools.SleepTools;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * future的使用
 */
public class UserFuture {

    private static class UserCallable implements Callable<Integer> {
        private int sum;
        @Override
        public Integer call() throws Exception {
            System.out.println("callable 子线程开始了");
            Thread.sleep(2000); //  让它抛出异常
            for (int i = 0; i < 5000; i++) {

                sum += i;
            }
            System.out.println("callable结果完成为：" + sum);
            return sum;
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        UserCallable userCallable = new UserCallable();
        FutureTask<Integer> futureTask = new FutureTask<>(userCallable);

        new Thread(futureTask).start();
        Random random = new Random();
        SleepTools.second(1);

        if (random.nextBoolean()){  //随机决定是获得结果还是终止任务
            System.out.println("get usercallable result:" + futureTask.get());
        }else {
            System.out.println("中断计算");
            futureTask.cancel(true);
        }
    }


}
