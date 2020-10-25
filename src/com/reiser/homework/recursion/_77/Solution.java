package com.reiser.homework.recursion._77;

import java.util.*;

/**
 * @author: reiserx
 * Date:2020/9/26
 * Des:https://leetcode-cn.com/problems/combinations/submissions/
 * 77. 组合
 * 回溯法，回溯就是穷举，可以在穷举的过程中剪枝优化
 */
public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (k <= 0 || n < k) {
            return res;
        }

        Deque<Integer> tmp = new ArrayDeque<>();
        gener(n, k, 1, tmp, res);
        return res;
    }

    private void gener(int n, int k, int begin, Deque<Integer> path, List<List<Integer>> result) {
        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = begin; i <= n - (k - path.size()) + 1; i++) {
            path.addLast(i);
            System.out.println("递归之前 => " + path);
            gener(n,k,i+1,path,result);
            path.removeLast();
            System.out.println("递归之后 => " + path);

        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.combine(4, 2));
    }
}
