[141. 环形链表](https://leetcode-cn.com/problems/linked-list-cycle/)

## 思路
双指针是链表解题的基本技巧
哨兵机制可以优化链表循环的逻辑

快慢指针可以解决这个问题，但是时间复杂度是O(n)
题目要求 O(1)

难道使用 hash ？