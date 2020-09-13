package com.reiser.homework.queue.validparentheses;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author: reiserx
 * Date:2020/9/12
 * Des:
 */
public class Solution {

    public boolean isValid(String s) {
        //是奇数肯定错误
        if (s.length() % 2 == 1) {
            return false;
        }

        Map<Character, Character> map = new HashMap<Character, Character>() {{
            put('{', '}');
            put('[', ']');
            put('(', ')');
        }};

        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (map.containsKey(ch)) {
                stack.push(map.get(ch));
            } else {
                if (stack.isEmpty() || stack.pop() != ch) {
                    return false;
                }
            }

        }
        return stack.isEmpty();
    }
}
