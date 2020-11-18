package com.ddot.springbootdemo.leetcode.DFSTest;

import java.util.Optional;

/**
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1]
 * 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），
 * 也不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格 [35, 37] ，
 * 因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 *
 */

public class Test02 {
    int m , n , k , res;
    boolean[][] visited;
    public int movingCount(int m, int n, int k) {
        this.m = m;
        this.n = n;
        this.k = k;
        visited = new boolean[m][n];
        res = 0;
        helper(0,0);
        return res;
    }
    public void helper(int i, int j){
        if(!isArea(i,j) || visited[i][j] || !isOk(i,j)) {
            return;
        }
        res ++;
        helper(i + 1, j);
        helper(i, j+ 1);
        visited[i][j] = true;
    }
    public boolean isArea(int i, int j){
        if(i < 0 || i >= m || j < 0 || j >= n){
            return false;
        }else{
            return true;
        }
    }
    public boolean isOk(int i, int j){
        int ans = i % 10 + i / 10 + j % 10 + j /10;
        return ans <= k;
    }

    public static void main(String[] args) {
        String a = "1233321";
        System.out.println(Optional.ofNullable(a).orElse("123"));

    }
}
