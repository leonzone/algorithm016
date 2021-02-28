package com.reiser.homework.project;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author: reiserx
 * Date:2021/2/24
 * Des:
 */
public class TopK {
    private PriorityQueue<Integer> heap;
    private int k;

    public TopK(int k) {
        this.k = k;
        heap = new PriorityQueue<>();
    }

    public void add(Integer num) {
        if (heap.size() < k) {
            heap.add(num);
        } else if (heap.peek() < num) {
            heap.poll();
            heap.add(num);
        }
    }

    private int[] getTop() {
        int size = heap.size();
        int[] res = new int[size];
        for (int i = 0; i < size; i++) {
            res[i] = heap.poll();
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 6, 2, 3, 5, 4, 8, 7, 9};
        TopK topK = new TopK(5);
        for (int i : arr) {
            topK.add(i);
        }
        System.out.println(Arrays.toString(topK.getTop()));

    }
}
