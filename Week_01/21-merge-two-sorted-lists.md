https://leetcode.com/problems/merge-two-sorted-lists/


合并两个有序链表
```java
public class MergeTwoLists {
    public static void main(String[] args) {
        MergeTwoLists solution = new MergeTwoLists();
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode newNode = new ListNode(-1);
        ListNode preNode = newNode;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                preNode.next = l1;
                l1 = l1.next;
            } else {
                preNode.next = l2;
                l2 = l2.next;
            }
            preNode = preNode.next;
        }
        preNode.next = l1 == null ? l2 : l1;
        return newNode.next;
    }
}
```