package com.ddot.springbootdemo.leetcode.arraytest;

/**
 * 数组中重复的数字
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 *
 */
public class Test05 {
    public int findRepeatNumber(int[] nums) {
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[nums[i]]++;             //不超过 0～n-1   新数组的位置为旧数组的值
            if (res[nums[i]] > 1) return nums[i];
        }

        return -1;
    }
}
