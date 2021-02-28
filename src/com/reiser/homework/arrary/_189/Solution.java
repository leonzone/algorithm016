package com.reiser.homework.arrary._189;

/**
 * @author: reiserx
 * Date:2020/12/27
 * Des:189. 旋转数组
 * https://leetcode-cn.com/problems/rotate-array/
 */
public class Solution {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        k = k % len;
        int count = 0;
        for (int startIndex = 0; count < len; startIndex++) {
            int curIndex = startIndex;
            int curValue = nums[curIndex];
            do {
                int nextIndex = (curIndex + k) % len;
                int tmpValue = nums[nextIndex];
                nums[nextIndex] = curValue;
                curValue = tmpValue;
                curIndex = nextIndex;
                count++;
            } while (startIndex != curIndex);
        }
    }
}
