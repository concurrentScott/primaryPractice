package com.ddot.springbootdemo.leetcode.arraytest;

import java.util.LinkedList;

public class Test17 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0){
            return new int[0];
        }

        LinkedList<Integer> queue = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];

        for (int i = 0; i < k; i++) {   //没形成窗口
            while (!queue.isEmpty() && queue.peekLast() < nums[i]) queue.removeLast();
            queue.addLast(nums[i]);
        }
        for (int i = k; i < nums.length; i++) {
            if (queue.peekFirst() ==  nums[k - i]) queue.removeFirst();
            while (!queue.isEmpty() && queue.peekLast() < nums[i]) queue.removeLast();
            queue.addLast(nums[i]);

            //res[i - k + 1]

        }


return nums;
    }

}
