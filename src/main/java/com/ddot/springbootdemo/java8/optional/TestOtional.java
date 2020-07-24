package com.ddot.springbootdemo.java8.optional;

import com.ddot.springbootdemo.java8.testlambda.Employee;
import org.junit.Test;

import java.util.Optional;

public class TestOtional {
    /**
     * optional类常用方法
     * optional.of(T t) 创建一个optional类
     * optional.empty() 创建一个空的optional实例
     * optional.ofNUllable(T t) t不为空 创建optional实例，否则创建空实例
     * isPresent() 判断是否包含值
     * orElse(T t) 如果调用对象包含值 返回该值 否则返回t
     * orElseGet(supplier s) 如果调用对象包含值 返回改值 否则返回 s提供的值
     * map(Funtion f) 如果有值对其处理 返回处理后的optional 否则返回optional.empty
     *
     * flateMap(Function mapper) :和map相似要求返回值 为optional
     *
     */
    @Test
    public void test1(){
        Optional<Employee> op = Optional.of(new Employee());

        //让空指针的范围更小 更容易发现
        Optional<Employee> op2 = Optional.of(null); //不能传入空对象 否则回报错
        Employee employee = op.get();
        Employee employee1 = op2.get();
        System.out.println(employee);
        System.out.println(employee1);
    }
    @Test
    public void test2(){
        Optional<Employee> op = Optional.empty();
        System.out.println(op.get());
    }

    @Test
    public void  test03(){
        Optional<Employee> op = Optional.ofNullable(new Employee());
        System.out.println(op.get());



        Optional<Employee> op2 = Optional.ofNullable(null);
        if (op2.isPresent()){
            System.out.println(op2.get());
        }
        Employee employee = op2.orElse(new Employee("ddot", 18, 10.0));
        System.out.println(employee);
    }

    @Test
    public void test04(){
        Optional<Employee> op = Optional.ofNullable(null);

        Employee employee = op.orElseGet(() -> new Employee());
    }

    @Test
    public void test05(){
        Optional<Employee> ddot = Optional.ofNullable(new Employee("ddot", 18, 10.0));

        Optional<String> s = ddot.map(employee -> {
            return employee.getName();
        });
    }

    @Test
    public void test06(){
        Optional<Employee> ddot = Optional.ofNullable(new Employee("ddot", 18, 10.0));

        Optional<String> s = ddot.flatMap(employee -> Optional.of(employee.getName()));
    }


    //例题
    @Test
    public void test07(){
        Man man = new Man();

        String gName = getGodnessName(man);

        Optional<NewMan> o = Optional.ofNullable(null);
        System.out.println(getGodnessName2(o));

    }

    //需求 获取一个男人女神的名字
    public String getGodnessName(Man man){
        return man.getGodness().getName();
    }

    public String getGodnessName2( Optional<NewMan> newMan){
        return newMan.orElse(new NewMan())
                .getGodness()   //得到一个optional
                .orElse(new Godness("mm"))
                .getName();

    }


}
