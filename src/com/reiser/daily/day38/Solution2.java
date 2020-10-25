package com.reiser.daily.day38;

/**
 * @author: reiserx
 * Date:2020/10/14
 * Des:
 */
public class Solution2 {
    public int rob(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int first1 = nums[0];
        int second1 = 0;

        int first2 = 0;
        int second2 = nums[1];
        // 状态转移
        // 情况1：i-1 偷了 i 不偷，
        // 情况2：i-2 偷了 i 就偷

        // 抢第一个
        for (int i = 2; i < nums.length-1; i++) {


            int temp1 = second1;
            second1 = Math.max(second1, first1 + nums[i]);
            first1=temp1;

        }
        // 不抢第一个
        for (int i = 2; i < nums.length; i++) {

            int temp2 = second2;
            second2 = Math.max(second2, first2 + nums[i]);
            first2=temp2;

        }

        return Math.max(second1,second2);
    }
}
