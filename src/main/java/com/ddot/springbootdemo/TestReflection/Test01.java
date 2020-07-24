package com.ddot.springbootdemo.TestReflection;


import java.lang.reflect.Method;
import java.util.Arrays;

public class Test01 {
    private  Class clazz;
    private static final String className = "TestReflection.User";

    public static void main(String[] args) throws Exception {
        Test01 test = new Test01();

        //System.out.println(new Test01().reflectionUer(className));

        //test.reflectionUserMethod(className);

        test.reflectionField(className);

    }

    //获取实例对象
    public Object reflectionUer(String className) throws IllegalAccessException, InstantiationException, ClassNotFoundException {

        //return User.class;
        User user = (User) this.clazz.forName(className).newInstance();

        return user;
    }
    //获取实例对象方法
    public void reflectionUserMethod(String className) throws Exception {
        clazz = Class.forName(className);
        Method[] methods = this.clazz.getMethods();
        //Arrays.stream(methods).forEach(System.out::println);
        System.out.println("*******");
        Method method = clazz.getDeclaredMethod("setUserName",String.class);
        Object o = clazz.newInstance();
        Object o1 = method.invoke(o,"ddot");
        System.out.println(o1);
    }
    //获取字段
    public void reflectionField(String className) throws Exception {
        //clazz = Class.forName(className);
        Class clazz = SonUser.class;

        /*Field[] fields = clazz.getDeclaredFields(); //private 也可以获取
        //Arrays.stream(fields).forEach(System.out::println);

        User user = new User("1","scott",22);
        Field field = clazz.getDeclaredField("userName");
        field.setAccessible(true);
        System.out.println(field.getName());
        field.set(user,"ddot");
        System.out.println(user);*/
        for (Class superClass = clazz; superClass != Object.class; superClass = superClass.getSuperclass()) {
            //System.out.println(superClass);
        }
        Class superClass = clazz.getSuperclass();
        System.out.println(superClass);

        Method[] methods = superClass.getMethods();

        Arrays.stream(methods).forEach(System.out::println);




    }

}
