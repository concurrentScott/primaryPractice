package com.ddot.springbootdemo.leetcode.arraytest;

import java.util.Arrays;

/**
 * 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。
 * 2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
 *
 */
public class Test12 {
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        int gap = 0;
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] == 0) count++;
            if (nums[i] == nums[i + 1] && nums[i] != 0) return false;
            if (nums[i + 1] - nums[i] > 1){
                gap += nums[i + 1] - nums[i] -1;
            }
        }
        return count == gap;
    }

    public static void main(String[] args) {
        int[] temp = {0,0,1,2,5};
        Test12 test12 = new Test12();
        System.out.println(test12.isStraight(temp));
    }
}
