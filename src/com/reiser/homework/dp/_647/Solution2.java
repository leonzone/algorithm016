package com.reiser.homework.dp._647;

/**
 * @author: reiserx
 * Date:2020/10/14
 * Des:
 * <p>
 * 由单个字符组成。（base case）
 * 由 2 个字符组成，且字符要相同。
 * 由多于 2 个字符组成，首尾字符相同，且剩余子串是一个回文串。
 */
public class Solution2 {
    public int countSubstrings(String s) {
        int count = 0;
        int length = s.length();
        boolean[] dp = new boolean[length];
        for (int j = 0; j < length; j++) {
            for (int i = 0; i <= j; i++) {
                // 只有一个字符
                if (i == j) {
                    dp[i] = true;
                    count++;
                } else if (j - i == 1 && s.charAt(j) == s.charAt(i)) {
                    dp[i] = true;
                    count++;
                } else if (j - i > 1 && (s.charAt(j) == s.charAt(i)) && dp[i+ 1]) {
                    dp[i] = true;
                    count++;
                }else{
                    dp[i] = false;
                }
            }
        }
        return count;

    }
}
