package com.ddot.springbootdemo.leetcode.arraytest;

import java.util.ArrayList;
import java.util.List;

/**
 * 三数之和
 */
public class Test02 {
    public static void main(String[] args) {
        int[] temp = new int[]{-1, 0, 1, 2, -1, -4};
        Test02 t = new Test02();
        System.out.println(t.threeSum(temp));
    }
    public List<List<Integer>> threeSum(int[] nums) {
        //List list = new ArrayList();
        List total = new ArrayList();
        for (int i = 0; i < nums.length; i++) {
            List list = new ArrayList();
            int sum = 0 - nums[i];
            for (int j = 0; j < nums.length; j++) {
                if (j != i){
                    int result = sum - nums[j];
                    if (list.contains(result)){
                        List small = new ArrayList();
                        small.add(nums[i]);
                        small.add(result);
                        small.add(nums[j]);

                        total.add(small);
                    }else {
                        list.add(nums[j]);

                    }
                }
            }

        }
        return total;
    }
}
