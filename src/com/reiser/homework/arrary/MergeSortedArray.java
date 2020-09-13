package com.reiser.homework.arrary;

/**
 * @author: reiserx
 * Date:2020/9/12
 * Des:合并有序数组: 从后往前指针
 */
public class MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int p = m + n - 1;

        while ((i >= 0) && (j > 0)) {
            nums1[p--] = nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
        }

        System.arraycopy(nums2, 0, nums1, 0, j + 1);

    }
}
