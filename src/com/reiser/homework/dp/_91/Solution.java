package com.reiser.homework.dp._91;

/**
 * @author: reiserx
 * Date:2020/10/13
 * Des:91. 解码方法
 *
 * https://leetcode-cn.com/problems/decode-ways/submissions/
 */
public class Solution {
    public int numDecodings(String s) {
        if (s.startsWith("0")) {
            return 0;
        }
        int pre = 1;
        int curr = 1;

        for (int i = 1; i < s.length(); i++) {
            int tmp = curr;

            if (s.charAt(i) == '0') {
                if (s.charAt(i-1) == '1' || s.charAt(i-1) == '2') {
                    curr = pre;
                } else {
                    return 0;
                }
            } else if (s.charAt(i - 1) == '1' || (s.charAt(i - 1) == '2' && s.charAt(i) > '0' && s.charAt(i) < '7')) {
                curr = curr + pre;
            }
            pre = tmp;
        }
        return curr;

    }
}
