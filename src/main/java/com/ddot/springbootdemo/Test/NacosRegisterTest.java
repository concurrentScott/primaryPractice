package com.ddot.springbootdemo.Test;

import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingFactory;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.pojo.Instance;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class NacosRegisterTest {

    public static void main(String[] args) throws Exception {
        register2Nacos();

    }


    public static void register2Nacos() throws Exception {
        Properties properties = new Properties();
        properties.setProperty("serverAddr", "127.0.0.1:8848");
        properties.setProperty("namespace", "aa743ae8-7287-4bc9-bc5e-71a4560cc953");

        NamingService naming = NamingFactory.createNamingService(properties);

        naming.registerInstance("desk-service", "11.11.11.11", 8888, "TEST1");


        System.out.println(naming.getAllInstances("scott-test"));


        Thread.sleep(Long.MAX_VALUE);
    }

    public static void register2Nacos1() throws Exception {
        Instance instance = new Instance();
        instance.setIp("55.55.55.55");
        instance.setPort(9999);
        instance.setHealthy(true);
        instance.setWeight(2.0);
        instance.setServiceName("desk-service");
        Map<String, String> instanceMeta = new HashMap<>();
        instanceMeta.put("serverAddr", "127.0.0.1:8848");
        instanceMeta.put("namespace", "aa743ae8-7287-4bc9-bc5e-71a4560cc953");
        instance.setMetadata(instanceMeta);

        Thread.sleep(Long.MAX_VALUE);
    }

}
