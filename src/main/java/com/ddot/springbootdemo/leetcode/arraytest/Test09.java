package com.ddot.springbootdemo.leetcode.arraytest;

/**
 *
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *  
 * 示例 1:
 *
 * 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
 * 输出: 2
 */

public class Test09 {
    public int majorityElement(int[] nums) {
        //摩尔投票法
        int vote = 0;
        int current = 0;
        for (int num : nums) {
            if (vote == 0) current = num;

            vote += current == num ? 1 : -1;
        }
        return current;

    }

}
