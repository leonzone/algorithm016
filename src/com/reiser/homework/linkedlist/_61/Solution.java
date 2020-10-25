package com.reiser.homework.linkedlist._61;

import com.reiser.tools.ListNode;

/**
 * @author: reiserx
 * Date:2020/9/9
 * Des:
 */

class Solution {

    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            cur = tmp.next;
            pre = tmp;

        }

        return cur;
    }
}