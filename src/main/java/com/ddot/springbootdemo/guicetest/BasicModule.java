package com.ddot.springbootdemo.guicetest;

import com.google.inject.AbstractModule;
import com.google.inject.Module;
import com.google.inject.Provides;
import com.google.inject.Singleton;

import javax.inject.Named;

public class BasicModule extends AbstractModule {
    //第一种定义依赖的方式
    @Override
    protected void configure() {
        //表明：需要communicate时候注入 DefaultCommunicateImpl
        bind(Communicater.class).to(DafaultCommunicaterImpl.class);

        bind(GuiceTest.class).toInstance(new GuiceTest(true));
    }

    //第二种定义依赖的方式

    @Provides
    @Singleton  //延时加载
    @Named("dafailtComvmun") //防止一个类型有多个实现类
    public Communicater getCommunicater(){
        return new DafaultCommunicaterImpl();
    }

    @Provides
    @Singleton
    @Named("anotherCommun")
    public Communicater getAnotherCommunicater(){
        return new AnotherCommunicaterImpl();
    }

}
