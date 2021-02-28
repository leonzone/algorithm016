package com.reiser.homework.classic._322;

import java.util.Arrays;

/**
 * @author: reiserx
 * Date:2020/11/18
 * Des:
 */
public class Solution {
    public int coinChange(int[] coins, int amount) {
        // dp 方程记录该金额最少的硬币数
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int coin : coins) {
                if (i - coin >= 0) {
                    //选 coin 或者不选 coin 取小者
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}
