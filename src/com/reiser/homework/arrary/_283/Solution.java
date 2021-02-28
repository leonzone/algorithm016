package com.reiser.homework.arrary._283;

/**
 * @author: reiserx
 * Date:2020/9/8
 * Des:
 */

// j 随着 i 一起移动
// i 遇见 0，j 会停留在 0 这个位置
// i 遇见非 0，就会和停留在 0 的 j 发生交换
public class Solution {
    public void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                if (i != j) {
                    nums[i] = 0;
                }
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        Solution solution = new Solution();
        solution.moveZeroes(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }


}
