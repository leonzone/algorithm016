package com.reiser.daily.day08;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: reiserx
 * Date:2020/9/14
 * Des:350. 两个数组的交集 II
 */
public class Intersection {

    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int item : nums1) {
            int count = map.getOrDefault(item, 0) + 1;
            map.put(item, count);
        }
        int[] intersection = new int[nums1.length];
        int index = 0;
        for (int num : nums2) {
            int count = map.getOrDefault(num, 0);
            if (count > 0) {
                intersection[index++] = num;
                count--;
                if (count > 0) {
                    map.put(num, count);
                } else {
                    map.remove(num);
                }
            }
        }
        return Arrays.copyOfRange(intersection, 0, index);
    }
}
