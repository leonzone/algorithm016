package com.reiser.homework.bit._231;

/**
 * @author: reiserx
 * Date:2020/11/4
 * Des:231. 2的幂
 * https://leetcode-cn.com/problems/power-of-two/
 */
public class Solution {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}
