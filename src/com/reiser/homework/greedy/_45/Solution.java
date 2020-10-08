package com.reiser.homework.greedy._45;

/**
 * @author: reiserx
 * Date:2020/10/2
 * Des:
 * 跳跃游戏 II
 */
public class Solution {

    public int jump(int[] nums) {
        int count = 0;
        //可以达到的最大位置
        int maxPostion = 0;
        //本次循环的最终位置
        int end = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxPostion = Math.max(maxPostion, i + nums[i]);
            if (i == end) {
                end = maxPostion;
                count++;
            }
        }
        return count;
    }
}
