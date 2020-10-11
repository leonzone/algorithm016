package com.reiser.daily.day32;

/**
 * @author: reiserx
 * Date:2020/10/11
 * Des:53. 最大子序和
 * https://leetcode-cn.com/problems/maximum-subarray/
 * 误区：我大概看一下，好像可以
 * 提升认知：找到一个自相似的方法，有重复性的办法，进行化繁为简，逻辑上是简洁的且能严谨证明
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
