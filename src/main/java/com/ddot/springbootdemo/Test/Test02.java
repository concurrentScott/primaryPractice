package com.ddot.springbootdemo.Test;

import java.util.Arrays;

public class Test02 {

    public static void main(String[] args) {
        String userId = "7;";
        String userId1 = "7";

        System.out.println(userId.contains(";"));
        String[] split = userId.split(";");
        System.out.println(Arrays.toString(split) + "___size:" + split.length);
        System.out.println(split[0]instanceof String);

    }
}
