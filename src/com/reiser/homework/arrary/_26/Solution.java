package com.reiser.homework.arrary._26;

/**
 * @author: reiserx
 * Date:2020/12/27
 * Des:26. 删除排序数组中的重复项
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int p = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[p] != nums[i]) {
                p++;
                nums[p] = nums[i];
            }
        }
        return p + 1;
    }

    /**
     * https://leetcode.com/problems/remove-duplicates-from-sorted-array/discuss/11780/5-lines-C%2B%2BJava-nicer-loops
     */
    public int removeDuplicates2(int[] nums) {
        int i = 0;
        for (int n : nums)
            if (i == 0 || n > nums[i - 1])
                nums[i++] = n;
        return i;
    }
}
