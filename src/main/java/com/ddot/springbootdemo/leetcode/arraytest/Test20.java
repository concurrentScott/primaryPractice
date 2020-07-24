package com.ddot.springbootdemo.leetcode.arraytest;

import java.util.Arrays;

/**
 *
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。
 * 请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 * 示例 1：
 *
 * 输入：nums = [4,1,4,6]
 * 输出：[1,6] 或 [6,1]
 *
 * 相同的数异或为0，不同的异或为1。0和任何数异或等于这个数本身。
 *
 * 所以，数组里面所有数异或 = 目标两个数异或 。 由于这两个数不同，所以异或结果必然不为0。
 *
 * 假设数组异或的二进制结果为10010，那么说明这两个数从右向左数第2位是不同的
 */
public class Test20 {
    public int[] singleNumbers(int[] nums) {
        int k = 0;
        for (int num : nums) {
            k ^= num;
        }
        int mark = 1;
        /**找到最后不同的一位*/
        while ((k & mark) == 0){
            mark <<= 1;
        }

        int a = 0;
        int b = 0;
        /**分组*/
        for (int num : nums) {
            if ((mark & num) == 0){
                a ^= num;
            }else {
                b ^= num;
            }
        }
        return new int[]{a,b};

    }
}
