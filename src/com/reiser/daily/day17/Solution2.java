package com.reiser.daily.day17;

import com.reiser.tools.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: reiserx
 * Date:2020/9/24
 * Des:剑指 Offer 06. 从尾到头打印链表
 * https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
 * 解法：递归
 */
public class Solution2 {

    List<Integer> list = new ArrayList<>();

    public int[] reversePrint(ListNode head) {
        reverse(head);
        int[] r = new int[list.size()];
        for (int i = 0; i < r.length; i++) {
            r[i] = list.get(i);
        }
        return r;
    }

    private void reverse(ListNode head) {
        if (head == null) {
            return;
        }
        reverse(head.next);
        list.add(head.val);
    }


}
