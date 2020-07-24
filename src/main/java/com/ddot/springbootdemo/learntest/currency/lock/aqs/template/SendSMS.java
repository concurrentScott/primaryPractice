package com.ddot.springbootdemo.learntest.currency.lock.aqs.template;

public class SendSMS extends SendCustom {
    @Override
    public void to() {
        System.out.println("to mm");
    }

    @Override
    public void from() {
        System.out.println("from ddot");

    }

    @Override
    public void content() {
        System.out.println("hellow");
    }

    @Override
    public void send() {
        System.out.println("send sms");
    }

    public static void main(String[] args) {
        SendCustom sendCustom = new SendSMS();
        sendCustom.sendMessage();
    }
}
