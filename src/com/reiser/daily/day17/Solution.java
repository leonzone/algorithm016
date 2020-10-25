package com.reiser.daily.day17;

import com.reiser.tools.ListNode;

import java.util.Stack;

/**
 * @author: reiserx
 * Date:2020/9/24
 * Des:剑指 Offer 06. 从尾到头打印链表
 * https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
 * 解法：辅助栈
 */
public class Solution {


    public int[] reversePrint(ListNode head) {
        Stack<ListNode> stack = new Stack<>();

        while (head != null) {
            stack.push(head);
            head = head.next;
        }

        int[] result = new int[stack.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = stack.pop().val;
        }
        return result;
    }


}
