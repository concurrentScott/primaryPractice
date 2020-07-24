package com.ddot.springbootdemo.learntest.currency.thread.atomic;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 引用类型的原子操作类
 */
public class UserAtomicReference {

    static AtomicReference<UserInfo> userRef = new AtomicReference<>();

    public static void main(String[] args) {
        UserInfo user1 = new UserInfo("ddot",15);
        userRef.set(user1);

        UserInfo user2 = new UserInfo("mm",14);
        userRef.compareAndSet(user1,user2);

        System.out.println(userRef.get().getName());
        System.out.println(userRef.get().getAge());

        System.out.println(user1.getAge());
        System.out.println(user1.getName());
    }


    static class UserInfo{
        private String name;
        private int age;

        public UserInfo(String name,Integer age){
            this.age = age;
            this.name = name;
        }


        public String getName() {
            return name;
        }


        public int getAge() {
            return age;
        }

    }
}
