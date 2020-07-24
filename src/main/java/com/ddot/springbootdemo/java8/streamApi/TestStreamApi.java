package com.ddot.springbootdemo.java8.streamApi;

import com.ddot.springbootdemo.java8.testlambda.Employee;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * 一，创建streamapi
 *
 * 二，中间操作
 *
 * 三，终止操作
 *
 */
public class TestStreamApi {
    //创建stream

    //四种方式
    @Test
    public void test01(){
        //1可以通过collection系列集合提供的stream()或者 parallelStream()获取
        List<String> list = new ArrayList<>();
        Stream<String> stringStream = list.stream();

        //2 通过Arrays中的静态方法stream()获取数组流
        Employee[] employees = new Employee[10];
        Stream<Employee> employeeStream = Arrays.stream(employees);

        //3 通过Stream的静态方法获取流
        Stream<String> streamStream = Stream.of("aa","bb");

        //4，创建无限流
        //迭代
        Stream<Integer> stream = Stream.iterate(0,(x) -> x + 2);
        stream.limit(10).forEach(System.out::println);

        //生成
        Stream.generate(() -> Math.random());



    }
}
