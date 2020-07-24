package com.ddot.springbootdemo.leetcode.stringtest;

public class Test05 {
    public String reverseWords(String s) {
        String[] strs = s.trim().split(" ");
        StringBuilder sb = new StringBuilder();

        for (int i = strs.length - 1; i >= 0; i--) {
            if (strs[i] != " "){
                sb.append(strs[i]);
            }
        }


        return null;
    }

}
