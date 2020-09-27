package com.reiser.daily.day21;

import java.util.PriorityQueue;

/**
 * @author: reiserx
 * Date:2020/9/27
 * Des: 面试题 17.09. 第 k 个数
 * https://leetcode-cn.com/problems/get-kth-magic-number-lcci/
 */
class Solution {
    int[] nums = {3, 5,7};
    public int getKthMagicNumber(int n) {
        PriorityQueue<Long> heap = new PriorityQueue<>();
        heap.add(1L);
        int count = 0;
        while (!heap.isEmpty()) {
            long c = heap.poll();
            if(++count >= n){
                return (int) c;
            }
            for (int num : nums) {
                long tmp = c * num;
                if (!heap.contains(tmp)) {
                    heap.add(tmp);
                }
            }
        }
        return -1;
    }
}
