package com.ddot.springbootdemo.java8.testlambda;


import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TestLambda3 {

    @Test
    //定制排序  先比年龄 后比较性别
    public void test01(){
        Collections.sort(employees,(x,y) -> {
            if (x.getAge() == y.getAge()){
                return x.getName().compareTo(y.getName());
            }else {
                return Integer.compare(x.getAge(),y.getAge());
            }
        });
    }

    @Test
    //处理字符串
    public void test02(){
        String str = handleString(" /t/t/tddot",s -> s.substring(0,5));
        String s1 = handleString(" /t/t/tddot",s -> s.toUpperCase());
        System.out.println(str);
        System.out.println(s1);
    }

    public String handleString(String str,Myfunction myfunction){
        return myfunction.getValue(str);
    }

    @Test
    //对两个long类型进行处理
    public void test03(){
        op(100L,200L,(x,y) -> x + y);

    }
    public void op(Long l1,Long l2,Myfunction2<Long,Long> mf){
        System.out.println(mf.getValue(l1,l2));
    }

    List<Employee> employees = Arrays.asList(
            new Employee("zs", 18, 9999.9),
            new Employee("ls", 30, 5555.5),
            new Employee("ww", 50, 6666.6),
            new Employee("z6", 16, 9999.9),
            new Employee("t7", 8, 3333.33)
    );





}
