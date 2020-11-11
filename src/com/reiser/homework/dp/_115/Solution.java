package com.reiser.homework.dp._115;

import java.util.Arrays;

/**
 * @author: reiserx
 * Date:2020/11/12
 * Des:
 */
public class Solution {
    public int numDistinct(String s, String t) {

        int m = t.length();
        int n = s.length();
        int[][] dp = new int[m + 1][n + 1];
        Arrays.fill(dp[0], 1);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (s.charAt(j) == t.charAt(i)) {
                    dp[i + 1][j + 1] = dp[i][j] + dp[i + 1][j];
                } else {
                    dp[i + 1][j + 1] = dp[i + 1][j];
                }
            }
        }

        return dp[m][n];
    }
}
