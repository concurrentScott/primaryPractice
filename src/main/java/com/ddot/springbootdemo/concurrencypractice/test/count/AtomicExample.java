package com.ddot.springbootdemo.concurrencypractice.test.count;

import com.ddot.springbootdemo.TestReflection.User;
import com.ddot.springbootdemo.concurrencypractice.annoation.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicReference;

@Slf4j
@ThreadSafe
public class AtomicExample {
    private static AtomicReference<Integer> count = new AtomicReference<>(0);

    private static AtomicReference<User> atomicUser = new AtomicReference<>(new User("1","1",1));
    public static void main(String[] args) {
        count.compareAndSet(0,2);  //count = 2
        count.compareAndSet(0,1);
        count.compareAndSet(1,3);
        count.compareAndSet(2,4);
        count.compareAndSet(3,5);
        log.info("count={}",count.get());

        //atomicUser.compareAndSet()
    }
}
