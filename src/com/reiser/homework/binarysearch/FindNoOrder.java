package com.reiser.homework.binarysearch;

/**
 * @author: reiserx
 * Date:2020/9/29
 * Des: 找无序点就是找最小值
 */
public class FindNoOrder {
    public static void main(String[] args) {
        FindNoOrder f = new FindNoOrder();
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int index = f.find(nums);
        System.out.println(index);
    }



    public int find(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while (low < high) {
            //使用位运算计算中间点
            int mid = low + ((high - low) >> 1);
            //说明右侧有序，无序点在左侧
            if (nums[mid] < nums[high]) {
                high = mid;
            } else {
                //否则，无序点在左侧
                low = mid + 1;
            }

        }

        return nums[low];
    }
}
