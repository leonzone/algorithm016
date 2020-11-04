package com.reiser.homework.bit._191;

/**
 * @author: reiserx
 * Date:2020/11/4
 * Des:191. 位1的个数
 * https://leetcode-cn.com/problems/number-of-1-bits/
 */
public class Solution {
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n &= n - 1;
        }
        return count;
    }
}
