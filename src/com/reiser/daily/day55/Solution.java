package com.reiser.daily.day55;

import java.util.TreeMap;

/**
 * @author: reiserx
 * Date:2020/11/1
 * Des:1122. 数组的相对排序
 * https://leetcode-cn.com/problems/relative-sort-array/
 * 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * 输出：[2,2,2,1,4,3,3,9,6,7,19]
 */
public class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int i : arr1) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int i = 0;
        for (int n : arr2) {
            for (int j = 0; j < map.get(n); j++) {
                arr1[i++] = n;
            }
            map.remove(n);
        }

        for (int n : map.keySet()) {
            for (int j = 0; j < map.get(n); j++) {
                arr1[i++] = n;
            }
        }

        return arr1;
    }
}
