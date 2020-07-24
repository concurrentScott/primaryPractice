package com.ddot.springbootdemo.java8.testlambda;


import org.junit.Test;

import java.util.*;

public class Testlambda {

    //原来的匿名内部类
    @Test
    public void test01() {
        Comparator<Integer> com = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        };

        TreeSet<Integer> ts = new TreeSet<>(com);

    }

    @Test
    public void test02() {
        Comparator<Integer> com = (x, y) -> Integer.compare(x, y);

        TreeSet<Integer> treeSet = new TreeSet<>(com);
    }

    //需求 获取当前公司中年龄大于35员工信息
    List<Employee> employees = Arrays.asList(
            new Employee("zs", 18, 9999.9),
            new Employee("ls", 30, 5555.5),
            new Employee("ww", 50, 6666.6),
            new Employee("z6", 16, 9999.9),
            new Employee("t7", 8, 3333.33)
    );

    @Test
    public void test03() {
        List<Employee> list = filterE(employees);

    }

    //需求 获取当前公司中年龄大于35员工信息
    public List<Employee> filterE(List<Employee> old) {
        List<Employee> news = new ArrayList<>();
        for (Employee employee : old) {
            if (employee.getAge() > 35) {
                news.add(employee);
            }

        }
        return news;
    }

    //工资大于5000；
    public List<Employee> filterE2(List<Employee> old) {
        List<Employee> news = new ArrayList<>();
        for (Employee employee : old) {
            if (employee.getSalary() > 5000) {
                news.add(employee);
            }

        }
        return news;
    }

    //优化方式1 策略模式
    public List<Employee> fiterEmployee(List<Employee> list, Mypractice<Employee> mypractice) {
        List<Employee> employees = new ArrayList<>();
        for (Employee employee : list) {
            if (mypractice.test(employee)) {
                employees.add(employee);
            }
        }
        return employees;
    }

    @Test
    public void test04() {
        List<Employee> list = fiterEmployee(employees, new FilterEmployeeByAge());
    }

    //优化方式2 匿名内部类
    @Test
    public void tese05(){
        List<Employee> list = fiterEmployee(employees, new Mypractice<Employee>() {
            @Override
            public boolean test(Employee employee) {
                return employee.getSalary() <= 5000;
            }
        });
    }
    //优化方式3 lambda表达式
    @Test
    public void tese06(){
        List<Employee> list = fiterEmployee(employees,  (employee) -> employee.getAge() <= 5000);
        list.forEach(System.out::println);

    }
    //优化方式4
    @Test
    public void tese07(){
        employees.stream()
                .filter((employee) -> employee.getSalary() > 5000)
                .limit(2)
                .forEach(System.out::println);

        employees.stream()
                .map(Employee::getName)
                .forEach(System.out::println);

    }

    private User cover(User user){

        user.age = 2;
        return user;
    }
    class User{
        int age ;
        public void setAge(int age){
            this.age = age;
        }


    }
    @Test
    public void tese08(){
        User user = new User();
        System.out.println(user);
        User user1 = cover(user);
        System.out.println(user1);

    }





    }
