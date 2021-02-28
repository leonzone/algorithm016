package com.reiser.homework.project.stock._123;

/**
 * @author: reiserx
 * Date:2020/12/9
 * Des:
 */
public class Solution {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0) {
            return 0;
        }
        int[][][] dp = new int[n][3][2];

        for (int i = 0; i < n; i++) {
            // 为什么 K  要倒叙
            for (int k = 2; k >= 1; k--) {
                if (i == 0) {
                    dp[i][k][0] = 0;
                    dp[i][k][1] = -prices[i];
                    continue;
                }
                dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
                dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);
            }
        }
        return dp[n - 1][2][0];


    }
}
