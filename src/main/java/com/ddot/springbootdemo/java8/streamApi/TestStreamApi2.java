package com.ddot.springbootdemo.java8.streamApi;

import com.ddot.springbootdemo.java8.testlambda.Employee;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

/**
 * 二，中间操作
 *
 *
 */
public class TestStreamApi2 {
    //创建stream

    //四种方式
    /**
     * 筛选与切片
     * filter--接收lambda,从流中排除某些元素
     * limit--截断流，控制元素的数量
     * skip(n) 跳过元素，返回一个丢掉前n个元素的流，元素不足n,返回一个空流，与limit(n)互补
     * distinct 筛选，通过流所生成元素的hashcode()和equals()去除重复元素
     */
    List<Employee> employees = Arrays.asList(
            new Employee("zs", 18, 9999.9),
            new Employee("ls", 30, 5555.5),
            new Employee("ww", 50, 6666.6),
            new Employee("z6", 16, 9999.9),
            new Employee("t7", 8, 3333.33)
    );
    @Test
    public void test01(){
        Stream<Employee> stream = employees.stream()
                .filter((employee -> {
                    System.out.println("中间操作");  //中间操作不打印任何结果
                    return employee.getAge() > 35;
                }));

        //终止操作
        //内部迭代
        stream.forEach(System.out::println);
    }

    //外部迭代
    @Test
    public void test02(){
        Iterator<Employee> it  = employees.iterator();

        while (it.hasNext()){
            System.out.println(it.next());
        }
    }
    @Test
    public void test03(){
        employees.stream()
                .filter(e -> {
                    System.out.println("短路"); //找到符合条件的数据，之后的操作不继续进行
                    return e.getSalary() > 5000;
                })
                .limit(5)
                .forEach(System.out::println);
    }

    @Test
    public void test04(){
        //skip
        employees.stream()
                .filter(e -> {
                    return e.getSalary() > 5000;
                })
                .skip(2)
                .forEach(System.out::println);
    }
    /**
     * 映射
     * map -- 接收lambda,将元素转换成其他形式或者提取信息。接收一个函数作为参数，该函数会被运用到每个元素上，并将其映射为一个新的元素
     * flatMap---接收一个函数作为参数，将流中的每一个值都换成另一个流，然后吧所有流连接成一个流
     */
    @Test
    public void test5(){
        List<String > list = Arrays.asList("aaa","bbb","ccc","ddd","eee");
        list.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);

        System.out.println("-------");

        employees.stream()
                .map(employee -> {
                    return employee.getAge();   //Employee::getAge()
                })
                .forEach(System.out::println);

        Stream<Stream<Character>> streamStream = list.stream()
                .map(TestStreamApi2::filterCharacter);

        streamStream.forEach(
                sm -> {
                    sm.forEach(System.out::println);
                }
        );

        System.out.println("-----------");

        Stream<Character> sm = list.stream()
                .flatMap(TestStreamApi2::filterCharacter);  //平滑映射

        sm.forEach(System.out::println);
    }

    public static Stream<Character> filterCharacter(String str){
        List<Character> list = new ArrayList<>();
        for (Character character : str.toCharArray()) {
            list.add(character);
        }
        return list.stream();
    }

    /**
     * 排序
     * sorted()--自然排序
     * sorted(Comparator com)-- 定制排序
     */
    @Test
    public void test06(){
        List<String> list = Arrays.asList("aaa","bbb","ccc","ddd","eee");
        //自然排序
        list.stream()
                .sorted()
                .forEach(System.out::println);
        System.out.println("自定排序——————");

        employees.stream()
                .sorted((employee,employee1) -> {
                    if (employee.getAge() ==  employee1.getAge()){
                        return employee.getName().compareTo(employee1.getName());
                    }else {
                        return Integer.compare(employee.getAge(),employee1.getAge());
                    }
                }).forEach(System.out::println);

    }

}
