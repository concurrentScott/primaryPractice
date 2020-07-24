package com.ddot.springbootdemo.java8.testlambda;

@FunctionalInterface
public interface Myfunction2<T,R> {

    R getValue(T t1,T t2);

}
