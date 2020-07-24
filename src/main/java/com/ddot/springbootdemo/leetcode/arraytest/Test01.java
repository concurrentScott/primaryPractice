package com.ddot.springbootdemo.leetcode.arraytest;

/**
 * 盛水最大面积
 */
public class Test01 {
    //双指针遍历一遍数组 时间复杂度为o(n)
    public int maxArea(int[] height){
        int left = 0,right = height.length - 1,maxArea = 0;
        while (left > right){
            int temp = Math.min(height[left],height[right]);
            maxArea = Math.max(maxArea, temp);
            if (height[left] < height[right]){
                left++;
            }else {
                right--;
            }
        }
        return maxArea;

    }
}
