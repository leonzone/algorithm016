package com.reiser.homework.strings._709;

/**
 * @author: reiserx
 * Date:2020/11/15
 * Des:709. 转换成小写字母
 * https://leetcode-cn.com/problems/to-lower-case
 * 65～90号为26个大写英文字母，
 * 97～122号为26个小写英文字母，
 */
public class Solution {
    public String toLowerCase(String str) {
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] < 91 && chars[i] > 64) {
                chars[i] = (char) (chars[i] + 32);
            }

        }
        return String.valueOf(chars);
    }
}
