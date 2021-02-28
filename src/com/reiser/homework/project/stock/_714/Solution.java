package com.reiser.homework.project.stock._714;

/**
 * @author: reiserx
 * Date:2020/12/9
 * Des:
 */
public class Solution {
    public int maxProfit(int[] prices, int fee) {

        if (prices.length == 0) {
            return 0;
        }
        int dp_i_0 = 0;
        int dp_i_1 = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            int tmp = dp_i_0;
            // - fee 为什么要放在这里
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, tmp - prices[i] - fee);
        }

        return dp_i_0;

    }
}
