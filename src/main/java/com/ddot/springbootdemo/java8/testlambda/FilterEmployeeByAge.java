package com.ddot.springbootdemo.java8.testlambda;

public class FilterEmployeeByAge implements Mypractice<Employee> {
    @Override
    public boolean test(Employee employee) {
        return employee.getAge() >= 35;
    }
}
