package com.ddot.springbootdemo.learntest.currency.container;

public class ByteCul {
    /**
     * 位运算
     * @param args
     */
    public static void main(String[] args) {
        int data = 4;
        System.out.println("the 4 is" + Integer.toBinaryString(data));

        /**
         * 与运算
         *   1 & 1 = 1
         *   1 & 0 = 0
         *   0 & 0 = 0
         *  位或运算
         *  1 ｜ 1 = 1
         *  1 ｜ 0 = 1
         *  0 ｜ 0 = 0
         *  位非 ～
         *  ～1 = 0
         *  ～0 = 1
         *  位 异或 ^
         *  1 ^ 1 = 0
         *  0 ^ 0 = 0
         *  1 ^ 0 = 1
         *  有符号左移动操作
         *  << 乘以2的移动位数方
         *
         *  正数 第31位为0 负数位1
         *
         * 有符号的右移动 >>
         * 无符号的移动
         *
         * //取模的操作
         * a % (2^n) == a & (2 ^ n - 1)
         */


    }
}
