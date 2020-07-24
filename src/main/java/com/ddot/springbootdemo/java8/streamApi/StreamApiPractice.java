package com.ddot.springbootdemo.java8.streamApi;


import com.ddot.springbootdemo.java8.testlambda.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamApiPractice {
    List<Employee> employees = Arrays.asList(
            new Employee("zs", 18, 9999.9, Employee.Status.FREE),
            new Employee("ls", 30, 5555.5, Employee.Status.FREE),
            new Employee("ww", 50, 6666.6, Employee.Status.BUSY),
            new Employee("z6", 16, 9999.9,Employee.Status.BUSY),
            new Employee("t7", 8, 3333.33, Employee.Status.VOCATION)
    );


    /**
     *  1，给定一个数字列表，返回一个由每一个数平方构成的列表
     *  1，2，3，4   --》 1，4，9，16
     */
    @Test
    public void test01(){
        Integer[] nums = {1,2,3,4,5};
        Arrays.stream(nums)
                .map(x -> (x * x))
                .forEach(System.out::println);

    }

    /**
     * 怎么用 map和reduce 方法数一数流中有多少个Employee呢
     */

    @Test
    public void test02(){
        Optional<Integer> optional = employees.stream().map(employee -> 1)
                .reduce(Integer::sum);
        System.out.println(optional);
    }

    /**
     * 找出空闲的员工，按照工资排序
     */
    @Test
    public void test03(){
        employees.stream()
                .filter(e -> e.getStatus().equals( Employee.Status.BUSY))
                .sorted((e1,e2) -> Double.compare(e1.getSalary(),e2.getSalary()))
                .forEach(System.out::print);
    }
    /**
     * 员工都有哪些状态
     */
    @Test
    public void test04(){
        employees.stream().map(employee -> employee.getStatus())
                .distinct()
                .forEach(System.out::println);
    }

    /**
     * 查询busy的员工，并且按照姓名排序
     */

    @Test
    public void test05(){
        employees.stream()
                .filter(employee -> employee.getStatus().equals(Employee.Status.BUSY))
                .sorted((e1,e2) -> e1.getName().compareTo(e2.getName()))
                .forEach(System.out::println);
    }
    /**
     * 返回所有员工姓名的字符串 并且按字母排序
     */
    @Test
    public void test06(){
        employees.stream()
                .map(employee -> employee.getName())
                .sorted((e1,e2) -> e1.compareTo(e2))
                .forEach(System.out::println);

       String str =  employees.stream()
                .map(employee -> employee.getName())
                .sorted((e1,e2) -> e1.compareTo(e2))
                .reduce("",String::concat);

        System.out.println(str);

    }
    /**
     * 有没有姓名叫李四的选手
     */
    @Test
    public void test07(){
        Boolean b = employees.stream().anyMatch(employee -> employee.getName().equals("ls"));
        System.out.println(b);
    }

    /**
     * 所有busy员工的工资
     */
    @Test
    public void test08(){
        employees.stream()
                .filter(employee -> employee.getStatus().equals(Employee.Status.BUSY))
                .map(employee -> employee.getSalary())
                .reduce(Double::sum);
    }

    /**
     * 所有员工中，工资最高的工资数
     */
    @Test
    public void test09(){
       Optional<Double> op =  employees.stream()
                .map(employee -> employee.getSalary())
                .max(Double::compareTo);
        System.out.println(op.get());
    }

    /**
     * 所有员工中，工资最低的员工
     */
    @Test
    public void test10(){
        Optional<Employee> op = employees.stream()
                .min((e1,e2) -> {
                    return Double.compare(e1.getSalary(),e2.getSalary());
                });
        System.out.println(op.get());

    }


}
