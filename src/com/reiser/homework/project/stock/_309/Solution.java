package com.reiser.homework.project.stock._309;

/**
 * @author: reiserx
 * Date:2020/12/9
 * Des:https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown
 * 有冷静期的股票买卖
 */
public class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int dp_i_0 = 0;
        int dp_i_1 = Integer.MIN_VALUE;
        int dp_pre_0 = 0;

        for (int i = 0; i < prices.length; i++) {
            int tmp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, dp_pre_0 - prices[i]);
            dp_pre_0 = tmp;
        }

        return dp_i_0;

    }
}
