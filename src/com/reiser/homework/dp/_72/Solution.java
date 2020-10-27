package com.reiser.homework.dp._72;

/**
 * @author: reiserx
 * Date:2020/10/26
 * Des:
 */
public class Solution {
    public int minDistance(String word1, String word2) {
        //行
        int m = word1.length();
        int n = word2.length();
        // 有一个字符串为空串
        if (n * m == 0) return n + m;
        // DP 数组
        int[][] dp = new int[m + 1][n + 1];

        // 边界状态初始化
        for (int i = 0; i < n + 1; i++) dp[0][i] = i;

        for (int i = 0; i < m + 1; i++)  dp[i][0] = i;

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                int top = dp[i][j - 1];
                int left = dp[i - 1][j];
                int leftTop = dp[i - 1][j - 1];
                // 此处的 i 比 word 的下标多 1，所以要 -1
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) leftTop -= 1;
                dp[i][j] = Math.min(leftTop, Math.min(left, top)) + 1;
            }
        }
        return dp[m][n];
    }
}
