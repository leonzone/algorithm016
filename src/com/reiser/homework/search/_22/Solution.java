package com.reiser.homework.search._22;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: reiserx
 * Date:2020/11/1
 * Des:22. 括号生成
 * https://leetcode-cn.com/problems/generate-parentheses/
 * 剪枝
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> ans = solution.generateParenthesis(3);
        for (String an : ans) {
            System.out.println(an);
        }
    }

    List<String> result = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        generate(0, 0, n, "");
        return result;
    }

    private void generate(int left, int right, int n, String str) {
        if (left == n && right == n) {
            result.add(str);
            return;
        }
        // left 只有小于 n 时才有意义
        if (left < n) {
            generate(left + 1, right, n, str + "(");
        }

        //要生成右括号，必有要左括号比右括号多
        if (left > right) {
            generate(left, right + 1, n, str + ")");
        }
    }
}
