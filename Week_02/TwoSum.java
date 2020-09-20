package com.reiser.daily.day03;

import com.reiser.tools.PrintUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: reiserx
 * Date:2020/9/9
 * Des:两数之和
 */
public class TwoSum {

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
