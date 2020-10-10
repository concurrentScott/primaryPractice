package com.ddot.springbootdemo.leetcode.dynamicprogramming;

public class Test04 {

    public String longestPalindrome(String s) {
        // 特判
        int len = s.length();
        if (len < 2) {
            return s;
        }

        int maxLen = 1;
        int begin = 0;

        // dp[i][j] 表示 s[i, j] 是否是回文串
        boolean[][] dp = new boolean[len][len];
        char[] charArray = s.toCharArray();

        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (charArray[i] != charArray[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }

                // 只要 dp[i][j] == true 成立，就表示子串 s[i..j] 是回文，此时记录回文长度和起始位置
                if (dp[i][j] && j - i + 1  > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }

        for (int i = 0; i < dp.length; i++) {
            for (int i1 = 0; i1 < dp.length; i1++) {
                System.out.print(dp[i][i1] + ",");
            }
            System.out.println();
        }
        System.out.println(dp[0][1]);     // i = 0 j = 1


        return s.substring(begin, begin + maxLen);
    }

    public static void main(String[] args) {
/*

       Test04 test04 = new Test04();
        String babad = test04.longestPalindrome("babad");
*/
        String url = "http://10.161.55.13:49135/dosm_sso/ssoLogin.html";
        String substring = url.substring(0, url.lastIndexOf("/"));
        String substring1 = substring.substring(0, substring.lastIndexOf("/"));

        System.out.println(substring1);

    }
}
