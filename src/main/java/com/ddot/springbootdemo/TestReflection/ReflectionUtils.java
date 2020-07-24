package com.ddot.springbootdemo.TestReflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionUtils {

    //获取字段
    public static Field getDeclaredField(Object object, String filedName) {

        for (Class<?> superClass = object.getClass(); superClass != Object.class; superClass = superClass.getSuperclass()) {
            try {
                return superClass.getDeclaredField(filedName);
            } catch (NoSuchFieldException e) {

            }
        }
        return null;
    }

    //验证方法的参数和返回值
    public static boolean validateMethod(String classPath,
                                         String methodName,
                                         String expectType,
                                         Class... parameterTypes) throws NoSuchMethodException {
        Method method = getDeclaredMethod(classPath, methodName, parameterTypes);
        if (method == null){
            throw new IllegalArgumentException("Could not find method [" + methodName + "]");
        }
        System.out.println(method.getParameterTypes());
        String temp = method.getReturnType().toString();
        String type = temp.substring(temp.lastIndexOf('.'));

        if (!expectType.equalsIgnoreCase(type)) return false;

        return true;
    }

    public static boolean val (Class... parameterType){

        Class[] type = {Integer.class,String.class};
        return parameterType .equals(type);
    }

    public static void main(String[] args) {
       // User user = new User(age);
        //ReflectionUtils.validateMethod("TestReflection.User","getUserNames",String.class);

       // System.out.println(val(Integer.class,String.class));
    }





    //执行方法
    public static Object invokeMethod(Object object,
                                      String classPath,
                                      String methodName,
                                      Object[] parameters,
                                      Class... parameterTypes) throws InvocationTargetException {

        Method method = null;
        try {
            method = getDeclaredMethod(classPath, methodName, parameterTypes);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        if (method == null) {
            throw new IllegalArgumentException("Could not find method [" + methodName + "] on target [" + object + "]");
        }
        method.setAccessible(true);
        try {
            return method.invoke(object, parameters);
        } catch (IllegalAccessException e) {

        }

        return null;
    }

    //获取方法类型
    public static Method getDeclaredMethod(String classPath,
                                           String methodName,
                                           Class... parameterTypes) throws NoSuchMethodException {


                Method method =  getClazz(classPath).getDeclaredMethod(methodName, parameterTypes);

        return null;
    }

    private static Class getClazz(String classPath)  {
        Class clazz = null;
        try {
             clazz = Class.forName(classPath);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return clazz;
    }

}
