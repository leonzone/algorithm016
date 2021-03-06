package com.reiser.homework.dp._300;

import java.util.Arrays;

/**
 * @author: reiserx
 * Date:2020/11/11
 * Des:300. 最长上升子序列
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/
 */
public class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int max = 1;

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                max = Math.max(max, dp[i]);
            }
        }

        return max;
    }
}
