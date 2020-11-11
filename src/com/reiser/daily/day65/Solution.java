package com.reiser.daily.day65;

import java.util.List;

/**
 * @author: reiserx
 * Date:2020/11/10
 * Des:120. 三角形最小路径和
 * https://leetcode-cn.com/problems/triangle/
 */
public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {

        int n = triangle.size();
        int[] dp = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                //状态转移方程 dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
                // 简化后：
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }

        }
        return dp[0];
    }
}
