package com.ddot.springbootdemo.leetcode.stringtest;

/**
 * 寻找一个数组的最长前缀
 *
 */
public class Test02 {
    public static void main(String[] args) {

    }
    public String longestCommonPrefix(String[] strs) {

        String str = strs[0];
        for (int i = 0; i < strs.length; i++) {
            while (strs[i].indexOf(str) != 0){
                str = str.substring(0,str.length() - 1);
            }
        }

        return str;
    }

        

}
