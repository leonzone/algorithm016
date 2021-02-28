package com.reiser.homework.classic._22;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: reiserx
 * Date:2020/11/19
 * Des:22. Generate Parentheses
 * https://leetcode.com/problems/generate-parentheses/
 */
public class Solution {

    List<String> result = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        generate(0, 0, n, "");
        return result;
    }

    private void generate(int left, int right, int n, String str) {
        if (left == n && right == n) {
            result.add(str);
        }
        if (left < n) {
            generate(left + 1, right, n, str + "(");
        }
        if (right < left) {
            generate(left, right + 1, n, str + ")");
        }
    }
}
