package com.ddot.springbootdemo.learntest.currency.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * futuretask用法
 * callable用法
 */
public class NewThread {
    private static class UserRunnable implements Runnable{

        @Override
        public void run() {
            System.out.println("implement Runnable");
        }
    }

    private static class UserCallable implements Callable<String>{

        @Override
        public String call() throws Exception {
            System.out.println("implement Callable");

            return "callresult";
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        UserRunnable userRunnable = new UserRunnable();
        new Thread(userRunnable).start();
        UserCallable userCallable = new UserCallable();

        FutureTask<String> futureTask = new FutureTask<>(userCallable);

        new Thread(futureTask).start();
        System.out.println(futureTask.get());

    }
}
