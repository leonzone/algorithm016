package com.reiser.daily.day32;

/**
 * @author: reiserx
 * Date:2020/10/11
 * Des:53. 最大子序和
 * https://leetcode-cn.com/problems/maximum-subarray/
 * dp:
 * a.分治（子问题） max_sum=Max(max_sum(i-1),0)+a[i]
 * b.状态数组
 * c.DP 方程
 */
public class Solution {
    public int maxSubArray(int[] nums) {
        int pre = 0;
        int max = nums[0];

        for (int num : nums) {
            pre = Math.max(pre + num, num);
            max = Math.max(max, pre);
        }
        return max;

    }
}
