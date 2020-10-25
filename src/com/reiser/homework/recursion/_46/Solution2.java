package com.reiser.homework.recursion._46;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author: reiserx
 * Date:2020/9/27
 * Des:46. 全排列
 * https://leetcode-cn.com/problems/permutations/submissions/
 */
public class Solution2 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        for (int num : nums) {
            output.add(num);
        }

        backTrack(0, output, result);
        return result;

    }

    private void backTrack(int first, List<Integer> output, List<List<Integer>> result) {
        if (first == output.size()) {
            result.add(new ArrayList<>(output));
            return;
        }

        for (int i = first; i < output.size(); i++) {
            Collections.swap(output, first, i);
            backTrack(first + 1, output, result);
            Collections.swap(output, first, i);
        }
    }
}
