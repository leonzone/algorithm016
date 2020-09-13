package com.reiser.daily.day10;

/**
 * @author: reiserx
 * Date:2020/9/16
 * Des:
 */
public class Solution {
    public String removeOuterParentheses(String S) {
        StringBuilder sb = new StringBuilder();
        int level = 0;
        for (char c : S.toCharArray()) {
            if (c == ')') {
                level--;
            } else if (level >= 0) {
                sb.append(c);
            } else if (c == '(') {
                level++;
            }

        }
        return sb.toString();
    }
}
