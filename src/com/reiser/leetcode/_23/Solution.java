package com.reiser.leetcode._23;

import com.reiser.tools.ListNode;

/**
 * @author: reiserx
 * Date:2021/1/6
 * Des:
 */
public class Solution {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return merge(lists, 0, lists.length - 1);

    }

    private ListNode merge(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }
        int mid = (left + right) / 2;
        ListNode l1 = merge(lists, left, mid);
        ListNode l2 = merge(lists, mid + 1, right);
        return mergeTwoLists(l1, l2);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode preNode = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                preNode.next = l1;
                l1 = l1.next;
            } else {
                preNode.next = l2;
                l2 = l2.next;
            }
            preNode = preNode.next;
        }

        preNode.next = l1 == null ? l2 : l1;
        return dummy.next;
    }
}
