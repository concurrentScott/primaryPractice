package com.ddot.springbootdemo.concurrencypractice.annoation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 线程安全的类
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE) //未在子节码文件中存在，通过反射可以拿到
public @interface Recommend {

    String value() default "";

}
