package com.reiser.homework.bit._190;

/**
 * @author: reiserx
 * Date:2020/11/4
 * Des:
 */
public class Solution {
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i <= 32; i++) {
            int tmp = n >> i;
            tmp = tmp & 1;
            tmp = tmp << (32 - i);
            result |= tmp;
        }
        return result;
    }
}
