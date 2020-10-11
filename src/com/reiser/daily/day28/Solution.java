package com.reiser.daily.day28;

/**
 * @author: reiserx
 * Date:2020/10/11
 * Des:169. 多数元素
 * https://leetcode-cn.com/problems/majority-element/submissions/
 */
class Solution {

    public int majorityElement(int[] nums) {
        int count = 0;
        int candidate = 0;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }
        return candidate;
    }
}
