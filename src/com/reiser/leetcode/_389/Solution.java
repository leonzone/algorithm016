package com.reiser.leetcode._389;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: reiserx
 * Date:2021/1/4
 * Des:
 */
public class Solution {
    public char findTheDifference(String s, String t) {
        if ("".equals(s)) {
            return t.charAt(0);
        }

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            Character key = s.charAt(i);
            Integer count = map.getOrDefault(key, 0);
            map.put(key, ++count);
        }

        for (int i = 0; i < t.length(); i++) {
            Character key = t.charAt(i);
            Integer count = map.getOrDefault(key, 0);
            if (count == 0) {
                return key;
            }
            map.put(key, --count);
        }
        return ' ';

    }


    public char findTheDifference2(String s, String t) {

        int[] cnt = new int[26];

        for (int i = 0; i < s.length(); i++) {
            cnt[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); ++i) {
            char ch = t.charAt(i);
            cnt[ch - 'a']--;
            if (cnt[ch - 'a'] < 0) {
                return ch;
            }
        }
        return ' ';

    }


    public char findTheDifference3(String s, String t) {

        char res = 0;
        for (char c: s.toCharArray()) {
            res ^= c;
        }
        for (char c: t.toCharArray()) {
            res ^= c;
        }
        return res;

    }
}
