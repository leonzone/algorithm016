package com.reiser.homework.stack._84;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author: reiserx
 * Date:2021/2/27
 * Des:84. 柱状图中最大的矩形
 * https://leetcode-cn.com/problems/largest-rectangle-in-histogram/
 */
class Solution2 {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(right, n);

        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                right[stack.peek()] = i;
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }



        int ans = 0;

        for (int i = 0; i < n; i++) {
            ans = Math.max((right[i] - left[i] - 1) * heights[i], ans);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] a = {6, 7, 5, 2, 4, 5, 9, 3};
//        int[] a = {2,1,5,6,2,3};

        Solution2 solution = new Solution2();
        System.out.println(solution.largestRectangleArea(a));
    }
}

