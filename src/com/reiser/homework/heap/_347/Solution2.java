package com.reiser.homework.heap._347;

import java.util.*;

/**
 * @author: reiserx
 * Date:2020/9/20
 * Des: 前 K 个高频元素,使用数组做桶排序
 */
public class Solution2 {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        int[] nums = {-1, -1};
        int[] r = solution.topKFrequent(nums, 1);
        for (int i : r) {
            System.out.println(i);
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] bucket = new List[nums.length + 1];

        for (Integer key : map.keySet()) {
            int frequency = map.get(key);
            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }

        List<Integer> result = new ArrayList<>();

        //数组的下标是重复次数，值就是 key，从后向前遍历
        for (int pos = bucket.length - 1; pos >= 0 && result.size() <= k; pos--) {
            if (bucket[pos] != null) {
                result.addAll(bucket[pos]);
            }
        }

//        return result.toArray();
        return null;
    }
}
