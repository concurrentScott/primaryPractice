package com.ddot.springbootdemo.leetcode.arraytest;

/**
 * 旋转数组90度
 * a 点坐标[i][j]，可以看做从左上角[0][0]向下走i，再向右走j；
 * 旋转后到 b 点，可以看做右上角[0][N-1]向左走i，再向下走j，即[j][N-1-i]；
 * 再旋转后到 c 点，可以看做右下角[N-1][N-1]向上走i，再向左走j，即[N-1-i][N-1-j]；
 * 再旋转后到 d 点，可以看做左下角[N-1][0]向右走i，再向上走j，即[N-1-j][i]；
 * 确定坐标后，把这四个坐标的数交换一下就行了。
 *
 */
public class Test04 {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int height = n / 2;
        int weight = (n + 1) / 2;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < weight; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-1-j][i];
                matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
                matrix[j][n-1-i] = temp;
            }
        }


    }
        

}
