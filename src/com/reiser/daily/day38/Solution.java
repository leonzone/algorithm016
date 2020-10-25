package com.reiser.daily.day38;

/**
 * @author: reiserx
 * Date:2020/10/14
 * Des:
 */
public class Solution {
    public int rob(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int length = nums.length;
        int[] dp = new int[length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);


        for (int i = 2; i < nums.length; i++) {
            // 状态转移
            // 情况1：i-1 偷了 i 不偷，
            // 情况2：i-2 偷了 i 就偷

            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[length - 1];
    }
}
