package com.reiser.daily.day35;

/**
 * @author: reiserx
 * Date:2020/10/11
 * Des:剑指 Offer 05. 替换空格
 * https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/
 */
public class Solution {
    public String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                sb.append("%20");
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}
