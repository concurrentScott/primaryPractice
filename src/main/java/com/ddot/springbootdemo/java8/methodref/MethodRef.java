package com.ddot.springbootdemo.java8.methodref;


import com.ddot.springbootdemo.java8.testlambda.Employee;
import org.junit.Test;

import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 方法引用 ：若Lambda体中的内容有方法已经实现了，可以使用方法引用
 *
 * （方法引用试lambda表达试的另一种表现形式）
 *
 * 主要有三种
 *
 * 对象：：实例方法名
 *
 * 类：：静态方法名
 *
 * 类：：实例方法名
 *
 *
 * 构造器引用
 * Classname::new
 */
public class MethodRef {

    //构造器引用
    @Test
    public void test06(){
        //有参构造器
        Function<Integer, Employee> function1 = (x) -> new Employee();
        Function<Integer,Employee> function = Employee::new;
        function.apply(1);
    }


    //构造器引用
    @Test
    public void test05(){
        Supplier<Employee > supplier = () -> new Employee();

        //构造器引用
        Supplier<Employee> supplier1 = Employee::new;
    }

    //类：：实例方法名字
    @Test
    public void test04(){
        BiPredicate<String,String> b = (x,y) -> x.equals(y);
        //第一个为调用者 ，第二个为参数时

        BiPredicate<String,String> b1 = String::equals;

    }

    //类：：静态方法名字
    @Test
    public void test03(){

        Comparator<Integer> comparator  = (x,y) -> Integer.compare(x,y);
        Comparator<Integer> comparator1 = Integer::compareTo;

    }


    //对象：：实例方法名字
    @Test
    public void test01(){
        Consumer<String> consumer = (x) -> System.out.println(x);

        /*PrintStream ps = System.out;
        Consumer<String> con1 = ps::println;*/

        Consumer<String> con2 = System.out::println;
        con2.accept("124");
    }

    //对象：：实例方法名字
    @Test
    public void test02(){
        Employee employee = new Employee();
        Supplier<String> supplier = () -> employee.getName();
        String str = supplier.get();
        System.out.println(str);

        Supplier<Integer> supplier1 = employee::getAge;
    }
}
