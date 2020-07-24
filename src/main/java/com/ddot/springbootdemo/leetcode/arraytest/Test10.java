package com.ddot.springbootdemo.leetcode.arraytest;

import java.util.Arrays;

/**
 * 给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中 B 中的元素 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
 *
 *  
 * 输入: [1,2,3,4,5]
 * 输出: [120,60,40,30,24]
 *
 */

public class Test10 {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        new Test10().constructArr(a);
    }
    public int[] constructArr(int[] a) {
        int[] b = new int[a.length];
        int temp = 1;
        for (int i = 0; i < a.length; i++) {
            b[i] = temp;
            temp *= a[i];
        }
        temp = 1;
        for (int i = a.length - 1; i >= 0; i--) {
            b[i] *= temp;
            temp *= a[i];
        }
        return b;

    }
}
