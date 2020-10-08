package com.reiser.homework.binarysearch._153;

/**
 * @author: reiserx
 * Date:2020/9/29
 * Des:
 */
public class Solution {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while (low < high) {
            //使用位运算计算中间点
            int mid = low + ((high - low) >> 1);
            //说明右侧有序，最小值在左侧
            if (nums[mid] < nums[high]) {
                high = mid;
            } else {
                low = mid + 1;
            }

        }

        return nums[low];
    }
}
