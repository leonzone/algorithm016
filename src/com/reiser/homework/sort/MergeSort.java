package com.reiser.homework.sort;

/**
 * @author: reiserx
 * Date:2020/11/8
 * Des:合并排序
 */
public class MergeSort {

    public void sort(int[] array, int begin, int end) {
        if (end <= begin) {
            return;
        }
        int mid = begin + ((end - begin) >> 1);
        sort(array, begin, mid);
        sort(array, mid + 1, end);
        merge(array, begin, mid, end);
    }

    private void merge(int[] array, int left, int mid, int right) {
        int[] tmp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;

        while (i <= mid && j <= right) {
            tmp[k++] = array[i] < array[j] ? array[i++] : array[j++];
        }

        while (i <= mid) {
            tmp[k++] = array[i++];
        }

        while (j <= right) {
            tmp[k++] = array[j++];
        }

        System.arraycopy(tmp, 0, array, left, tmp.length);
    }
}
