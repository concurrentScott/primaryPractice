package com.ddot.springbootdemo.Test;

import java.util.Random;

public class Parent {
    public Parent(String name) {
        this.name = name;
    }
    public Parent(){

        this.name = new Random().nextInt(100) + ":";
    }

    private String name;

    @Override
    public String toString() {
        return "Parent{" +
                "name='" + name + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Son son = new Son();
        Bro bro = new Bro();
        System.out.println(son.getParent());
        System.out.println(bro.getParent());

    }
}
class Son extends Parent{
    private String sonName;
    @Override
    public String toString() {
        return "Son{" +
                "sonName='" + sonName + '\'' +
                '}';
    }
    public String getParent(){
        return super.toString();
    }
}
class Bro extends Parent{
    private String broName;

    @Override
    public String toString() {
        return "Bro{" +
                "broName='" + broName + '\'' +
                '}';
    }

    public String getParent(){
        return super.toString();
    }
}


