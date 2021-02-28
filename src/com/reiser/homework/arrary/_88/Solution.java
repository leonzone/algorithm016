package com.reiser.homework.arrary._88;

/**
 * @author: reiserx
 * Date:2020/12/26
 * Des:88. 合并两个有序数组
 * https://leetcode-cn.com/problems/merge-sorted-array/
 */

// 从后往前合并
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int q = m + n - 1;
        while (p1 >= 0 && p2 >= 0) {
            nums1[q--] = nums1[p1] > nums2[p2] ? nums1[p1--] : nums2[p2--];
        }
        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
    }
}