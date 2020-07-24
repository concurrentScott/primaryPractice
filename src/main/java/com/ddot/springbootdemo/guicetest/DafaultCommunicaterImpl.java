package com.ddot.springbootdemo.guicetest;


public class DafaultCommunicaterImpl implements Communicater {
    @Override
    public boolean sendMessage(String message) {
        System.out.println("send msessage" + message);
        return true;
    }
}
