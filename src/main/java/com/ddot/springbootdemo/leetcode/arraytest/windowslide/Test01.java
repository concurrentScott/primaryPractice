package com.ddot.springbootdemo.leetcode.arraytest.windowslide;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 *
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 *
 * 输入：target = 9
 * 输出：[[2,3,4],[4,5]]
 *
 * 输入：target = 15
 * 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 */
public class Test01 {

    public int[][] findContinuousSequence(int target) {
        int left = 1;
        int right = 2;
        int sum = left + right;
        List<int[]> res = new ArrayList<>();

        while (left <= target / 2){
            if (sum == target){
                int[] part = new int[right - left + 1];
                for (int i = 0; i < part.length; i++) {
                    part[i] = left + i;
                }
                res.add(part);
                sum -= left++;
            }else if (sum > target){
                sum -= left++;
            }else {
                sum += ++right;
            }
        }

        return res.toArray(new int[res.size()][]);
    }


    public static void main(String[] args) {
        int res = 1;
        System.out.println(res == Const.ONE_RESULT? Const.SUCCESS : Const.FALSE);

    }



}
