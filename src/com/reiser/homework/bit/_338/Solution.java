package com.reiser.homework.bit._338;

/**
 * @author: reiserx
 * Date:2020/11/4
 * Des:338. 比特位计数
 * https://leetcode-cn.com/problems/counting-bits/
 * 奇数：二进制表示中，奇数一定比前面那个偶数多一个 1，因为多的就是最低位的 1
 * 偶数：二进制表示中，偶数中 1 的个数一定和除以 2 之后的那个数一样多
 */
public class Solution {
    public int[] countBits(int num) {
        int[] count = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            if ((i & 1) == 1) {
                count[i] = count[i - 1] + 1;
            } else {
                count[i] = count[i / 2];
            }
        }
        return count;
    }
}
