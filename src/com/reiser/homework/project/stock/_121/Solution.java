package com.reiser.homework.project.stock._121;

/**
 * @author: reiserx
 * Date:2020/12/9
 * Des:https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 * 股票买卖，只能买卖一次
 */
public class Solution {

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] test = {7, 1, 5, 3, 6, 4};
        System.out.println(s.maxProfit(test));
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0) {
            return 0;
        }
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
//            dp[i][1][1] = max(dp[i-1][1][1], dp[i-1][0][0] - prices[i])
//                        = max(dp[i-1][1][1], -prices[i])
//            解释：k = 0 时不允许交易，所以 dp[i-1][0][0] = 0。
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
        }

        return dp[n - 1][0];

    }

    public int maxProfit2(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int dp_i_0 = 0;
        int dp_i_1 = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, -prices[i]);
        }

        return dp_i_0;
    }
}
