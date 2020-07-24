package com.ddot.springbootdemo.leetcode.dynamicprogramming;

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 */
public class Test01 {
    /*
    解法一 动态规划算法
     */
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0){
                nums[i] = nums[0];
            }else {
                nums[i] = Math.max(nums[i],nums[i] + nums[i - 1]);
                res = Math.max(res, nums[i]);
            }

        }
        return res;
    }
}
