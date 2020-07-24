package com.ddot.springbootdemo.learntest.currency.lock.aqs.template;

import java.util.Date;

/**
 * 模版方法模式
 */
public abstract class SendCustom {

    public abstract void to();

    public abstract void from();

    public abstract void content();

    public void date(){
        System.out.println(new Date());
    }

    public abstract void send();

    //框架方法
    public void sendMessage(){
        to();
        from();
        content();
        date();
        send();
    }

}
