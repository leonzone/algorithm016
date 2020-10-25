package com.reiser.homework.heap._Offer49;

import java.util.PriorityQueue;

/**
 * @author: reiserx
 * Date:2020/9/20
 * Des:剑指 Offer 49. 丑数
 */
public class Solution {
    int[] uglynums = {2, 3, 5};

    public int nthUglyNumber(int n) {

        PriorityQueue<Long> heap = new PriorityQueue<>();
        heap.add(1L);
        int count = 0;
        while (!heap.isEmpty()) {
            long c = heap.poll();
            // if (heap.size() > n) {
            //     return (int) c;
            // }
            if(++count >= n){
                return (int) c;
            }

            for (int num : uglynums) {
                long tmp = c * num;
                if (!heap.contains(tmp)) {
                    heap.add(tmp);
                }
            }
        }
        return -1;
    }
}
