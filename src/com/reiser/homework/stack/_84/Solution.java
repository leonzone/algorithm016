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
class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        // 每根柱子的左边界，右边界：右边第一个比自己小的柱子,
        int[] left = new int[n];
        // 每根柱子的右边界，左边界：左侧且最近的小于其高度的柱子
        int[] right = new int[n];
        Arrays.fill(right, n);

        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; ++i) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                //更新 右边界;右边界：右边第一个比自己小的柱子,
                right[stack.peek()] = i;
                //找到右边界了，出栈
                stack.pop();
            }
            //一根柱子的左侧且最近的小于其高度的柱子
            left[i] = (stack.isEmpty() ? -1 : stack.peek());
            stack.push(i);
        }

        int ans = 0;
        // 面积 = 高度 x（右边界-左边界-1）
        for (int i = 0; i < n; ++i) {
            ans = Math.max(ans, (right[i] - left[i] - 1) * heights[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] a = {6, 7, 5, 2, 4, 5, 9, 3};
//        int[] a = {2,1,5,6,2,3};

        Solution solution = new Solution();
        System.out.println(solution.largestRectangleArea(a));
    }
}

