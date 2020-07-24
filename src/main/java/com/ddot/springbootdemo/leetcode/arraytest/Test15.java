package com.ddot.springbootdemo.leetcode.arraytest;

public class Test15 {
    public int missingNumber(int[] nums) {
        int left = 0,right = nums.length - 1;
        while (left < right){
            int mid = (left + right) / 2;
            if (mid != nums[mid]){
                right = mid;
            }
            left = mid + 1;
        }

        return left;
    }
}
