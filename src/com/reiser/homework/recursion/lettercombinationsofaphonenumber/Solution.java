package com.reiser.homework.recursion.lettercombinationsofaphonenumber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: reiserx
 * Date:2020/9/26
 * Des:https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 * 17. 电话号码的字母组合
 */
public class Solution {

    Map<Character, String> map = new HashMap<Character, String>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};

    public static void main(String[] args) {
        Solution solution=new Solution();
        List<String> strings = solution.letterCombinations("23");
        System.out.println(strings);

    }

    public List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<>();
        gener("", 0, digits, result);
        return result;
    }

    private void gener(String str, int level, String digits, List<String> result) {
        if (level == digits.length()) {
            result.add(str);
            return;
        }
        char[] letters = map.get(digits.charAt(level)).toCharArray();
        for (char letter : letters) {
            gener(str + letter, level+1, digits, result);
        }

    }
}
