package com.ddot.springbootdemo.java8.streamApi;

import com.ddot.springbootdemo.java8.testlambda.Employee;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 终止操作
 */
public class TestStreamApi3 {

    List<Employee> employees = Arrays.asList(
            new Employee("zs", 18, 9999.9, Employee.Status.FREE),
            new Employee("ls", 30, 5555.5, Employee.Status.FREE),
            new Employee("ww", 50, 6666.6, Employee.Status.BUSY),
            new Employee("z6", 16, 9999.9,Employee.Status.BUSY),
            new Employee("t7", 8, 3333.33, Employee.Status.VOCATION)
    );
    /**
     * 查找与匹配
     * allMatch 检查是否匹配所有元素
     * anyMatch 检查是否至少匹配一个元素
     * noneMatche 检查是否没有匹配所有元素
     * findFirst 返回第一个元素
     * count 返回流中元素都总个数
     * max 返回流中都最大值
     * min 返回流中的最小值
     */
    @Test
    public void test01(){
        //allMatch 检查是否匹配所有元素
         boolean b1 = employees.stream()
                .allMatch(e -> {
                    return e.getStatus().equals(Employee.Status.BUSY);
                });

         //anyMatch 检查是否至少匹配一个元素
         boolean b2 = employees.stream()
                 .anyMatch(e -> {
                     return e.getStatus().equals(Employee.Status.BUSY);
                 });
         boolean b3 = employees.stream()
                 .noneMatch(e ->{
                     return e.getStatus().equals(Employee.Status.BUSY);
                 });


        //findFirst 返回第一个元素
        Optional<Employee> op = employees.stream().sorted((e1, e2) -> {
             return Double.compare(e1.getSalary(),e2.getSalary());
        })
                .findFirst();

        op.orElse(new Employee());

        //findAny 返回流中元素都总个数
        Optional<Employee > op1 = employees.parallelStream()    //多个线程进行寻找
                .findAny();
    }
    @Test
    public void test02(){
        //count 数量计算
        Long count = employees.stream().count();
        System.out.println(count);

        //max
        Optional<Employee> op = employees.stream().max((e1,e2) ->{
            return Double.compare(e1.getSalary(),e2.getSalary());
                }
        );

        //min
        employees.stream().map(Employee::getSalary)
                .min(Double::compareTo);

    }

    /**
     * 规约
     * reduce(T identity,BinaryOperator) / reduce(BinaryOperator) 可以将流中元素反复结合起来，得到一个值
     */
    @Test
    public void test03(){

        List<Integer> list = Arrays.asList(1,2,3,4,5);

        Integer sum = list.stream().reduce(0,(x,y) -> x + y);
        System.out.println(sum); //55

        Optional<Double> op //返回结果一定不为空都返回optional
                = employees.stream().map(Employee::getSalary)
                .reduce(Double::sum);
        System.out.println(op.get());

        //map-reduce 模式
    }

    /**
     * 收集将流转化为其他形式，接收一个collection接口的实现  用于给Stream中元素做汇总的方法
     */
    @Test
    public void test04(){
        List<String> list = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.toList());

        Set<String> stringSet = employees.stream()
        .map(Employee::getName)
        .collect(Collectors.toSet());

        employees.stream()
                .map(Employee::getName)
                .collect(Collectors.toCollection(HashSet::new));
    }

    @Test
    public void test05(){
        //总数
        Long count = employees.stream()
                .collect(Collectors.counting());    //计算个数

        //平均值
        employees.stream()
                .collect(Collectors.averagingDouble(Employee::getSalary));

        //工资总和
        employees.stream().collect(Collectors.summarizingDouble(Employee::getAge));

        //最大值
        Optional<Employee> max = employees.stream().collect(Collectors.maxBy((x,y) -> {
            return Double.compare(x.getSalary(),y.getSalary());
        }));
        System.out.println(max.get());

        //最小值
        Optional<Double> min = employees.stream()
                .map(Employee::getSalary)
                .collect(Collectors.minBy(Double::compare));
        System.out.println(min.get());
    }

    //分组
    @Test
    public void test06(){
        Map<Employee.Status,List<Employee> > map = employees.stream()
                .collect(Collectors.groupingBy(Employee::getStatus));

        System.out.println(map);
    }
    //多级分组
    @Test
    public void test07(){
        Map<Employee.Status,Map<String,List<Employee>>> map =  employees.stream()
                .collect(Collectors.groupingBy(Employee::getStatus,Collectors.groupingBy(e -> {
                    if (e.getAge() < 35){
                        return "青年";
                    }else {
                        return "中年";
                    }
                })));
        System.out.println(map);
    }

    //分区
    @Test
    public void test08(){
        Map<Boolean,List<Employee>> map =
                employees.stream().collect(Collectors.partitioningBy(e -> e.getSalary() > 8000 ));
    }
    @Test
    public void test09(){
        DoubleSummaryStatistics dms = employees.stream()
                .collect(Collectors.summarizingDouble(Employee::getSalary));
        dms.getAverage();
    }

    //将集合中所有元素的属性连接到一起
    @Test
    public void test10(){
        String str = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.joining("，"));

        System.out.println(str);
    }





}
