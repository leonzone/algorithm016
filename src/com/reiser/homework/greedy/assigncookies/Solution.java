package com.reiser.homework.greedy.assigncookies;

import java.util.Arrays;

/**
 * @author: reiserx
 * Date:2020/9/29
 * Des:
 */
public class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        for (int i = 0, j = 0; i < g.length && j < s.length;) {
            if (s[j] >= g[i]) {
                count++;
                i++;
            }
            j++;
        }
        return count;

    }
}