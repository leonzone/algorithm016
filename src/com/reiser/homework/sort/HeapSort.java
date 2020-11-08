package com.reiser.homework.sort;

import java.util.PriorityQueue;

/**
 * @author: reiserx
 * Date:2020/11/8
 * Des:堆排序
 */
public class HeapSort {
    public void sort(int[] array) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i : array) {
            queue.add(i);
        }
        for (int i = 0; i < array.length && queue.size() > 0; i++) {
            array[i] = queue.poll();
        }
    }
}
