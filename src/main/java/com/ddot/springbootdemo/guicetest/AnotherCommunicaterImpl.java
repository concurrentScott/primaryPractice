package com.ddot.springbootdemo.guicetest;

public class AnotherCommunicaterImpl implements Communicater{
    @Override
    public boolean sendMessage(String message) {
        System.out.println("另一种communicater" + message);
        return true;
    }
}
