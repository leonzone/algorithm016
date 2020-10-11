package com.reiser.daily.day33;

/**
 * @author: reiserx
 * Date:2020/10/11
 * Des:1143. 最长公共子序列
 * https://leetcode-cn.com/problems/longest-common-subsequence/
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.longestCommonSubsequence("abcde","ace"));
    }
    public int longestCommonSubsequence(String text1, String text2) {

        int m = text1.length();
        int n = text2.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }

        }
        return dp[m][n];

    }
}
