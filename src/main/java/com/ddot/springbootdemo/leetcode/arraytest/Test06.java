package com.ddot.springbootdemo.leetcode.arraytest;

/**
 *在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 */

public class Test06 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int length = matrix[0].length - 1;
        int height = 0;

        while (length > 0 && height< matrix.length){
            if (target > matrix[height][length]){
                height++;
            } else if (target < matrix[height][length]) {
                length --;
            }else{
                return  true;
            }
        }
        return false;

    }
}
