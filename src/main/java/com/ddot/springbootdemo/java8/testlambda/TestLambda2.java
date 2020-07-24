package com.ddot.springbootdemo.java8.testlambda;


import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * 一，lambda表达式基础语法 java8引入新操作符——>
 *
 * 操作符将lambda表达式拆成左右两侧
 * 左侧 lambda 表达式的参数列表
 * 右侧 表达式执行的功能 lambda体
 *
 * 语法格式1 无参数 无返回值
 * () -> system.out.println
 *
 * 语法格式2 有一个参数 无返回值
 *
 * 语法格式3 只有一个参数 ，小括号可省略
 *
 * 语法格式4 有两个以上的参数，lambda体中有多条语句 必须使用大括号
 *
 * 语法格式5  lambda体中只有一条语句 大括号省略 return省略不写
 *
 * 语法格式6 lambda表达式参数列表的数据类型可以省略不写 jvm可通过上下文推断
 *
 * 上联 左右遇一括号省
 * 下联 左侧推断类型省
 * 横批 能省则省
 *
 * 二，lambda表达式需要函数式接口的支持
 * 函数式接口 接口中只有一个抽象方法的接口，称为函数式接口 可以使用@functioninterfce修饰
 * 可以检查是否为函数式接口
 */
public class TestLambda2 {

    @Test
    public void test01(){
        int num = 1;        //jdk7以嵌必须是final    默认加上  局部变量在同级方法中
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("hellow!" + num);
            }
        };
        System.out.println("!!!!!!!!");

        Runnable r1 = () -> System.out.println("hellow2");
    }

    @Test
    public void test02(){
        Consumer<String> consumer = t -> System.out.println(t);
        consumer.accept("ddot");

    }

    @Test
    public void test03(){
        Comparator<Integer> comparator = (x,y) -> {
            System.out.println("****");
            return Integer.compare(x, y);
        };

    }
    @Test
    public void test04(){
        //String[] str = {"aaa","bbb","ccc"};
    }
    //需求 对一个数进行运算
    @Test
    public void test05(){
        Integer res = option(10, (x) -> x + x);

    }
    public Integer option(Integer a,Myfunc myfunc){
        return myfunc.getValue(a);
    }



}
