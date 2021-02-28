package com.reiser.leetcode._290;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author: reiserx
 * Date:2021/1/5
 * Des:
 */
public class Solution {
    public boolean wordPattern(String pattern, String s) {

        HashMap<Character, String> map = new HashMap<>();
        HashSet<String> set = new HashSet<>();
        String[] array = s.split(" ");

        if (pattern.length() != array.length) {
            return false;
        }

        for (int i = 0; i < pattern.length(); i++) {
            char key = pattern.charAt(i);
            if (map.containsKey(key)) {
                if (!map.get(key).equals(array[i])) {
                    return false;
                }
            } else {
                if (set.contains(array[i])) {
                    return false;
                }
                map.put(key, array[i]);
                set.add(array[i]);
            }
        }

        return true;
    }
}
