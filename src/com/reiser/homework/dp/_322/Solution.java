package com.reiser.homework.dp._322;

/**
 * @author: reiserx
 * Date:2020/10/13
 * Des:暴力求解
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] coins = {1, 2, 5};
        System.out.println(solution.coinChange(coins, 11));
    }

    int[] coins;

    public int coinChange(int[] coins, int amount) {
        this.coins = coins;
        return dp(amount);

    }

    private int dp(int amount) {
        if (amount == 0) {
            return 0;
        }

        if (amount < 0) {
            return -1;
        }
        int result = Integer.MAX_VALUE;
        for (int coin : coins) {
            int subProblem = dp(amount - coin);
            if (subProblem == -1) {
                continue;
            }
            result = Math.min(result, subProblem + 1);
        }
        return result;
    }
}
