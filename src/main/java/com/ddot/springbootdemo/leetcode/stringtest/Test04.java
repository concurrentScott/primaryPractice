package com.ddot.springbootdemo.leetcode.stringtest;

public class Test04 {
    public char firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (s.indexOf(chars[i]) == s.lastIndexOf(chars[i]))
                return chars[i];
        }
        return ' ';
    }

}
