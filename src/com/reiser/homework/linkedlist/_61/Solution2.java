package com.reiser.homework.linkedlist._61;

import com.reiser.tools.ListNode;

/**
 * @author: reiserx
 * Date:2020/9/9
 * Des:递归解法
 */

class Solution2 {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
}