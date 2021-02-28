package com.reiser.homework.stack._42;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author: reiserx
 * Date:2021/2/28
 * Des:42. 接雨水
 * https://leetcode-cn.com/problems/trapping-rain-water/
 */
public class Solution {
    public int trap(int[] height) {
        int sum = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < height.length; i++) {
            //如果栈不空并且当前指向的高度大于栈顶高度就一直循环
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int h = height[stack.pop()];
                if (stack.isEmpty()) {
                    break;
                }
                //两堵墙之前的距离。
                int distance = i - stack.peek() - 1;
                // height[stack.peek()] 是左墙的高度，height[i] 是右墙的高度，取矮的那个
                int min = Math.min(height[stack.peek()], height[i]);
                sum = sum + distance * (min - h);
            }
            stack.push(i);
        }
        return sum;
    }

//    public int trap(int[] height) {
//        int sum = 0;
//        Stack<Integer> stack = new Stack<>();
//        int current = 0;
//        while (current < height.length) {
//            //如果栈不空并且当前指向的高度大于栈顶高度就一直循环
//            while (!stack.empty() && height[current] > height[stack.peek()]) {
//                int h = height[stack.peek()]; //取出要出栈的元素
//                stack.pop(); //出栈
//                if (stack.empty()) { // 栈空就出去
//                    break;
//                }
//                int distance = current - stack.peek() - 1; //两堵墙之前的距离。
//                int min = Math.min(height[stack.peek()], height[current]);
//                sum = sum + distance * (min - h);
//            }
//            stack.push(current); //当前指向的墙入栈
//            current++; //指针后移
//        }
//        return sum;
//    }
}
