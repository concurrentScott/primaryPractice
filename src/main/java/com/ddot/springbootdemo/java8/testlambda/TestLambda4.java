package com.ddot.springbootdemo.java8.testlambda;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * java 内置核心函数试接口
 *
 * Consume<T>:消费型 接口
 * void accept(T t);
 *
 * Supplier</T> 供给型接口
 * T get();
 *
 *
 * Function<T,R> 函数型接口
 * R apply (T t)
 *
 * Predicate<T> 断言试接口
 * boolean test(T t);
 *
 */
public class TestLambda4 {

    //断言形 接口
    @Test
    public void test04(){
        List<String > list = Arrays.asList("hello","ddot","mm");
        List<String> str = filterStr(list,(s) -> s.length() > 3);

        for (String s : str) {
            System.out.println(s);
        }
    }

    //需求 指定字符串添加到集合中
    public List<String> filterStr(List<String> list, Predicate<String> pre){
        List<String> newList = new ArrayList<>();
        for (String s : list) {
            if (pre.test(s)){
                newList.add(s);
            }
            
        }
        return newList;
    }


    //Function<T,R> 函数型接口

    @Test
    public void test03(){
        String newStr = StringHander("ddot2mm",(s -> s.toUpperCase().substring(0,2)));
        System.out.println(newStr);
    }

    //处理字符串对需求
    public String StringHander(String str, Function<String,String> function){

        return function.apply(str);
    }


    //Supplier</T> 供给型接口

    @Test
    public void test02(){
        List<Integer> list = getNumber(10,() -> (int)Math.random() * 100);
    }
    //需求 产生一些整数 并放入集合中
    public List<Integer> getNumber(int num, Supplier<Integer> supplier){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            list.add(supplier.get());

        }
        return list;
    }



        //Consumer<T>:消费型 接口
    @Test
    public void test01(){
        happy(1000,money -> System.out.println(money + "dbj"));

    }
    public void happy(double money, Consumer<Double> consumer){
        consumer.accept(money);
    }


}
