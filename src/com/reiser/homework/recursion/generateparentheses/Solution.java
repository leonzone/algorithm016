package com.reiser.homework.recursion.generateparentheses;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: reiserx
 * Date:2020/9/22
 * Des: 生成括号
 * https://leetcode-cn.com/problems/generate-parentheses/
 */
public class Solution {
    public static void main(String[] args) {
        new Solution().generateParenthesis(3);
    }
    List<String> result=new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        generate(0, 0, n, "");
        return result;
    }

    private void generate(int left, int right, int n, String str) {
        // terminator
        if (left == n && right == n) {
            result.add(str);
            return;
        }
        // process current logic

        // drill down
        if (left < n) {
            generate(left + 1, right, n, str + "(");
        }


        if (left > right) {
            generate(left, right + 1, n, str + ")");
        }


        // restore current status

    }
}
