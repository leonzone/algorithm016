package com.reiser.daily.day30;

import com.reiser.tools.PrintUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: reiserx
 * Date:2020/10/11
 * Des:1.两数之和
 * https://leetcode-cn.com/problems/two-sum/description/
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2, 7, 11, 15};
        int[] r = solution.twoSum(nums, 9);
        PrintUtil.out(r);
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> tagets = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int t = target - nums[i];
            if (tagets.containsKey(t)) {
                return new int[]{tagets.get(t), i};
            }
            tagets.put(nums[i], i);
        }
        return null;
    }
}
