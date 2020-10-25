package com.reiser.homework.recursion._47;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: reiserx
 * Date:2020/9/27
 * Des:https://leetcode-cn.com/problems/permutations-ii/
 * 47. 全排列 II
 */
public class Solution2 {

    boolean[] visited;

    public List<List<Integer>> permuteUnique(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> perm = new ArrayList<>();
        visited = new boolean[nums.length];
        backTrack(0, nums, perm, result);
        return result;

    }

    private void backTrack(int index, int[] nums, List<Integer> perm, List<List<Integer>> result) {
        if (index == nums.length) {
            result.add(new ArrayList<>(perm));
            return;
        }

        for (int i = index; i < nums.length; i++) {
            if (visited[i] || (i != 0 && nums[i] == nums[i - 1] && !visited[i - 1])) {
                continue;
            }

            perm.add(nums[i]);
            visited[i] = true;
            backTrack(index + 1, nums, perm, result);
            visited[i] = false;
            perm.remove(index);

        }

    }
}
