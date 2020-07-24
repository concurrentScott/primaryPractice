package com.ddot.springbootdemo.leetcode.arraytest;

public class Test11 {

    public static void main(String[] args) {
        int[] temp = {5,7,7,8,8,10};

        int res = new Test11().search(temp,8);
        System.out.println( res);

    }

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int count = 0;

        while (left < right){
            int mid = (left + right) / 2;
            if (nums[mid] > target) right = mid;
            if (nums[mid] < target) left = mid + 1;
            if (nums[mid] == target) right = mid;
        }
        System.out.println(left);

        while (left<nums.length&&nums[left++] == target){
            count++;
        }

        return count;
    }

}
