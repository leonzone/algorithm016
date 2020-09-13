package com.reiser.daily.day09;

import java.util.PriorityQueue;

/**
 * @author: reiserx
 * Date:2020/9/15
 * Des:
 */
public class SlidingWindow {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0) {
            return new int[0];
        }
        int[] result = new int[nums.length - k + 1];
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>((a,b)->(b-a));

        for (int i = 0; i < nums.length; i++) {
            int start = i - k;
            if (start > 0) {
                maxQueue.remove(nums[start]);
            }
            maxQueue.add(nums[i]);
            if (maxQueue.size() == k) {
                result[i - k + 1] = maxQueue.peek();
            }
        }

        return result;
    }
}
