package com.reiser.homework.sort._242;

/**
 * @author: reiserx
 * Date:2020/11/9
 * Des:242. 有效的字母异位词
 * https://leetcode-cn.com/submissions/detail/109762179/
 */
public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] counter = new int[26];

        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']++;
        }

        for (int i : counter) {
            if (i != 0) {
                return false;
            }
        }

        return true;

    }
}
