package com.reiser.homework.stack._155;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author: reiserx
 * Date:2020/9/12
 * Des:155. 最小栈
 * https://leetcode-cn.com/problems/min-stack/
 * 一个栈同时保存当前值和栈内最小值
 */
public class Solution {

    class MinStack {
        Deque<Integer> xStack;
        Deque<Integer> minStack;

        public MinStack() {
            xStack = new LinkedList<Integer>();
            minStack = new LinkedList<Integer>();
            minStack.push(Integer.MAX_VALUE);
        }

        public void push(int x) {
            xStack.push(x);
            minStack.push(Math.min(minStack.peek(), x));
        }

        public void pop() {
            xStack.pop();
            minStack.pop();
        }

        public int top() {
            return xStack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }

}
