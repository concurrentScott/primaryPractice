package com.ddot.springbootdemo.learntest.currency.thread.atomic;

import java.util.concurrent.atomic.AtomicStampedReference;

public class UserAtomicStampedReference {
    static AtomicStampedReference<String> asr = new AtomicStampedReference<>("ddot",0);

    public static void main(String[] args) throws InterruptedException {
        final int oldStamp = asr.getStamp();    //初始版本号

        final String oldReference = asr.getReference(); //初始值

        System.out.println(oldReference + "==="  +oldStamp);

        Thread rightReference = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "当前变量值" + oldReference +
                    "当前版本戳" + oldStamp +
                    asr.compareAndSet(oldReference, oldReference + "java", oldStamp, oldStamp + 1));
        });

        //错误stamp
        Thread errorReference = new Thread(() ->{
            String reference = asr.getReference();
            System.out.println(Thread.currentThread().getName() + "当前变量值" + reference +
                    "当前版本戳" + asr.getStamp() +
                    asr.compareAndSet(reference,reference + "c",oldStamp,oldStamp + 1));
        });

        rightReference.start();
        rightReference.join();
        errorReference.start();
        rightReference.join();
        System.out.println("reference" + asr.getReference() + "=====stamp" + asr.getStamp());


    }
    }

