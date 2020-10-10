package com.ddot.springbootdemo.concurrencypractice.test.future;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.FutureTask;


@Slf4j
public class FutureTaskExample {

    public static void main(String[] args) throws Exception {
        FutureTask<String> futureTask = new FutureTask<>(() -> {
            log.info("callable");
            Thread.sleep(5000);
            return "ok";
        });

        new Thread(futureTask).start();
        log.info("do main   ");
        Thread.sleep(1000);
        String result = futureTask.get();

        log.info("result:{}",result);
    }
}
