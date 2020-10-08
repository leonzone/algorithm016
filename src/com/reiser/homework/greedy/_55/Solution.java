package com.reiser.homework.greedy._55;

/**
 * @author: reiserx
 * Date:2020/9/30
 * Des:
 */
public class Solution {
    public boolean canJump(int[] nums) {

        if (nums == null || nums.length == 0) {
            return false;
        }

        int target = nums.length - 1;

        for (int i = nums.length - 2; i >= 0; i--) {
            int step = nums[i];
            if (i + step >= target) {
                target = i;
            }
        }
        return target == 0;

    }
}
