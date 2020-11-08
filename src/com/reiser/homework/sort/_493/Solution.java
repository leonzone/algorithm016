package com.reiser.homework.sort._493;

/**
 * @author: reiserx
 * Date:2020/11/9
 * Des:493. 翻转对
 * https://leetcode-cn.com/problems/reverse-pairs/
 */
public class Solution {

    public int reversePairs(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        return mergeSort(nums, 0, nums.length - 1);
    }

    private int mergeSort(int[] nums, int left, int right) {
        if (left >= right) {
            return 0;
        }
        int mid = left + (right - left) / 2;
        int count = mergeSort(nums, left, mid) + mergeSort(nums, mid + 1, right);
        int[] tmp = new int[right - left + 1];

        int i = left, t = left, c = 0;
        for (int j = mid + 1; j <= right; j++, c++) {
            while (i <= mid && nums[i] <= 2 * (long)nums[j]) {
                i++;
            }
            while (t <= mid && nums[t] < nums[j]) {
                tmp[c++] = nums[t++];
            }
            tmp[c] = nums[j];
            count += mid - i + 1;
        }
        while (t <= mid) {
            tmp[c++] = nums[t++];
        }

        System.arraycopy(tmp, 0, nums, left, right - left + 1);
        return count;
    }
}
