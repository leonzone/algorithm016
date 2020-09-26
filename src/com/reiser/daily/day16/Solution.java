package com.reiser.daily.day16;

/**
 * @author: reiserx
 * Date:2020/9/22
 * Des:https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/
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
