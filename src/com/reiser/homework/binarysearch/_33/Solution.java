package com.reiser.homework.binarysearch._33;

/**
 * @author: reiserx
 * Date:2020/10/2
 * Des: 33. 搜索旋转排序数组
 */
public class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (nums[mid] == target) {
                return mid;
            }
            //mid 左部分有序
            if (nums[low] <= nums[mid]) {
                //target 在左半部分
                if (target >= nums[low] && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    //target 在无序的右半部分
                    low = mid + 1;
                }
            } else {
                if (target <= nums[high] && target > nums[mid]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }


        }

        return -1;
    }
}
