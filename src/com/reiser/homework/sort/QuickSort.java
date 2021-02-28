package com.reiser.homework.sort;

/**
 * @author: reiserx
 * Date:2020/11/8
 * Des:快速排序
 */
public class QuickSort {
    public void sort(int[] array, int begin, int end) {
        if (end <= begin) {
            return;
        }
        int pivot = partition(array, begin, end);
        sort(array, begin, pivot - 1);
        sort(array, pivot + 1, end);
    }

    private int partition(int[] a, int begin, int end) {
        int counter = begin;
        int pivot = end;
        // 保证 pivot 左边的都比 pivot 小，右边的都比 pivot 大
        for (int i = begin; i < end; i++) {
            if (a[i] < a[pivot]) {
                int tmp = a[i];
                a[i] = a[counter];
                a[counter] = tmp;
                counter++;
            }
        }
        int temp = a[pivot]; a[pivot] = a[counter]; a[counter] = temp;

        return counter;
    }
}
