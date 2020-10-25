package com.reiser.daily.day37;

import java.util.Arrays;

/**
 * @author: reiserx
 * Date:2020/10/13
 * Des:322. 零钱兑换
 * https://leetcode-cn.com/problems/coin-change/submissions/
 * 动态规划
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] coins = {1, 2, 5};
        System.out.println(solution.coinChange(coins, 11));
    }


    public int coinChange(int[] coins, int amount) {
        // dp table
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        //穷举遍历
        for (int i = 0; i < dp.length; i++) {
            for (int coin : coins) {
                if (i - coin < 0) {
                    continue;
                }
                // 状态转移方程 最优子结构
                dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }
        }
        return dp[amount];

    }

}
