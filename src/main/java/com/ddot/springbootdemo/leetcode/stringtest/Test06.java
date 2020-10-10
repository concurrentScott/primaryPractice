package com.ddot.springbootdemo.leetcode.stringtest;

/***
 * 外观数列
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 */

public class Test06 {
    public String countAndSay(int n) {
        if (n == 1){
            return "1";
        }
        StringBuilder sb = new StringBuilder();
        String pre = countAndSay(n - 1);

        int index = 0;
        for (int i = 1; i < pre.length()+1; i++) {
            if (pre.charAt(i) != pre.charAt(index)){
                sb.append(i - index).append(pre.charAt(index));
                index = i;
            }else if (i == pre.length()){
                return sb.append(i - index).append(pre.charAt(index)).toString();
            }
        }
        return sb.toString();

    }
}
