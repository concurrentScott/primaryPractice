package com.ddot.springbootdemo.concurrencypractice.test.count;

import com.ddot.springbootdemo.concurrencypractice.annoation.ThreadSafe;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReference;

@Slf4j
@ThreadSafe
public class AtomicExample2 {
    @Getter
    private volatile int count = 100;   /**必须要volatile修饰，并且非static*/

    private static AtomicIntegerFieldUpdater<AtomicExample2> updater =
            AtomicIntegerFieldUpdater.newUpdater(AtomicExample2.class,"count");

    private static AtomicExample2 example2 = new AtomicExample2();

    public static void main(String[] args) {
        if (updater.compareAndSet(example2,100,120)){
            log.info("success1 {}",example2.getCount());
        }
        if (updater.compareAndSet(example2,100,120)){
            log.info("success2 {}",example2.getCount());
        }else {
            log.info("fail");
        }
    }
}
