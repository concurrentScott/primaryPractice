package com.ddot.springbootdemo.leetcode.bytecul;

/**
 *
 * 不用加减乘除做加法
 *
 *
 */
public class Test01 {
    public int add(int a, int b) {
        if (a == 0 || b == 0) return a == 0 ? b : a;
        //两个二进制的数 先计算没有进位
        int noUp = a ^ b;   //没进位  一样则为0 不一样则为1
        int up = (a & b) << 1;
        return noUp + up;


    }


}
