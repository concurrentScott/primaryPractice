package com.ddot.springbootdemo.Test;

public class Test01 {

    public static boolean isNum(String str){
        for (int i = str.length(); --i >= 0;) {
            int chr = str.charAt(i);
            if (chr < 48 || chr > 57)
                return false;
        }
        return true;
    }

    public static boolean isNum1(String str){
        try {
            Double.parseDouble(str);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(5.00 == 5);

        System.out.println(isNum1("5zz"));
    }
}
