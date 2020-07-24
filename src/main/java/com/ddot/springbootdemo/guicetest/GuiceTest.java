package com.ddot.springbootdemo.guicetest;


import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

import javax.inject.Named;

public class GuiceTest {

    @Inject
    @Named("dafailtComvmun") //防止一个类型有多个实现类
    private Communicater communicater;

    @Inject
    @Named("anotherCommun")
    private Communicater anotherCommunicater;

    public GuiceTest(Boolean keepRecords){
        if (keepRecords){
            System.out.println("Message logging enabled");
        }
    }
    public boolean sendMessage(String message){
        communicater.sendMessage(message);
        anotherCommunicater.sendMessage(message);

        return true;
    }

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new BasicModule());

        GuiceTest gt = injector.getInstance(GuiceTest.class);

        gt.sendMessage("123");

    }


}
