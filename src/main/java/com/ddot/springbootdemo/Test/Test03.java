package com.ddot.springbootdemo.Test;

import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingFactory;
import com.alibaba.nacos.api.naming.NamingService;

import java.util.Arrays;
import java.util.Properties;

public class Test03 {

    public static void main(String[] args) throws NacosException, InterruptedException {
        Properties properties = new Properties();
        properties.setProperty("serverAddr", "127.0.0.1:8848");
        properties.setProperty("namespace", "aa743ae8-7287-4bc9-bc5e-71a4560cc953");

        NamingService naming = NamingFactory.createNamingService(properties);

        naming.registerInstance("desk-service", "11.11.11.11", 8888, "TEST1");

       // naming.registerInstance("cmdb-service", "2.2.2.2", 9999, "TEST1");

        System.out.println(naming.getAllInstances("scott-test"));

//        naming.deregisterInstance("cmdb-service", "2.2.2.2", 9999, "DEFAULT");

        Thread.sleep(Long.MAX_VALUE);

    }
}
