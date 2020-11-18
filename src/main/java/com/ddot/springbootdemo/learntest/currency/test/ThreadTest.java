package com.ddot.springbootdemo.learntest.currency.test;

import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingFactory;
import com.alibaba.nacos.api.naming.NamingService;
import com.ddot.springbootdemo.TestReflection.User;

import java.util.Properties;

public class ThreadTest {

    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();

        String serverAddr = "10.0.3.59:9949";
        String nameSpace = "dcb1aacc-c3ab-4f77-8ae5-489554080eb8";
        properties.setProperty("serverAddr", serverAddr);
        properties.setProperty("namespace", nameSpace);


        NamingService naming = NamingFactory.createNamingService(properties);

        naming.registerInstance("test", "10.0.4.241", 4433);

        Thread.sleep(Integer.MAX_VALUE);

    }


    public User getUser(){
        return new User(Thread.currentThread().getName(),Thread.currentThread().getName(),20);
    }

}
