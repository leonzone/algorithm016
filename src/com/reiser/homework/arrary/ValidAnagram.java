package com.reiser.homework.arrary;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: reiserx
 * Date:2020/9/20
 * Des:有效的字母异位词
 */
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }

        for (int i : counter) {
            if (i != 0) {
                return false;
            }
        }
        Map<Character,Integer> map=new HashMap<>();
       char a='a';
        map.getOrDefault(a,0);
        return true;
    }
}
