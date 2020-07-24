package com.ddot.springbootdemo.leetcode.dynamicprogramming;

/**
 * 输入一个整型数组，数组里有正数也有负数。数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 *
 * 要求时间复杂度为O(n)。
 *
 * [-2,1,-3,4,-1,2,1,-5,4]
 * [-2,1,-2,4,3,5,6,1,5]
 *
 */
public class Test03 {
    //动态规划 算法  前一个值为最大值  这个值为最大值
    //以 num[i] 结尾为最大 则 num[i-1] 为正数
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > 0){
                nums[i] += nums[i - 1];
            }
            res = Math.max(res,nums[i]);

        }
        return res;
    }

    public static void main(String[] args) {

    }

}
