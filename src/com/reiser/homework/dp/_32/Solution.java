package com.reiser.homework.dp._32;

/**
 * @author: reiserx
 * Date:2020/10/22
 * Des:32. 最长有效括号
 * https://leetcode-cn.com/problems/longest-valid-parentheses
 */
public class Solution {
    public int longestValidParentheses(String s) {
        int ans = 0;
        int[] dp = new int[s.length()];

        for (int i = 1; i < dp.length; i++) {
            // 只计算 ） 结尾的
            if (s.charAt(i) == ')') {
                //计算（）形式
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                    //遇见 ）） 时，需要先判断 第一个 ）是否为有效括号，且要找到 i - dp[i - 1] - 1
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                ans = Math.max(ans, dp[i]);
            }
        }

        return ans;
    }
}
