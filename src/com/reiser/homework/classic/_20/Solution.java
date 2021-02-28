package com.reiser.homework.classic._20;

import java.util.Stack;

/**
 * @author: reiserx
 * Date:2020/11/19
 * Des:20. 有效的括号
 * https://leetcode-cn.com/problems/valid-parentheses/
 */
public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }
}
