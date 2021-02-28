package com.reiser.homework.project.stock._188;

/**
 * @author: reiserx
 * Date:2020/12/10
 * Des:
 * 为什么 K  要倒叙：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv/solution/zhuang-tai-ya-suo-shi-guan-yu-kshi-fou-dao-xu-yao-/
 */
public class Solution {
    public int maxProfit(int max_k, int[] prices) {
        int n = prices.length;
        if (n == 0) {
            return 0;
        }
        int[][][] dp = new int[n][max_k + 1][2];

        for (int i = 0; i < n; i++) {
            //dp 需要遍历，故倒叙遍历 k
            for (int k = max_k; k >= 1; k--) {
                //初始化
                if (i == 0) {
                    dp[i][k][0] = 0;
                    dp[i][k][1] = -prices[i];
                    continue;
                }
                //状态转移方程
                dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
                dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);
            }
        }
        return dp[n - 1][max_k][0];
    }
}
