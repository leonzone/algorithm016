# 学习笔记

## 本周学习收获
- 不死磕。特别是看到 leetcode 上自己三年前的提交，为了刷 AC 而死磕，最后放弃了。
- 多练习
- 多总结
- 多和群里的同学交流
- 第一遍刷题在 IDEA 上，后面几次直接在 leetcode 网页上

## 收获解题套路

链表-双指针解题
递归-不要纠结每一步，只关心最新的。递归本来就是不自然的

## 印象最深的代码

### 1.找入环点
```java
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        //快慢指针找环
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            //相遇时慢指针到入环点的距离 == 起点到慢指针的距离
            if (fast == slow) {
                fast = head;
                while (fast != slow) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return fast;
            }
        }
        return null;
    }
```

### 2.三数之和
```java
    // 先排序，然后两个指针左右夹逼找到值
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return Collections.emptyList();
        }

        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum > 0) {
                    while (j < k && nums[k] == nums[--k]) ;
                } else if (sum < 0) {
                    while (j < k && nums[j] == nums[++j]) ;
                } else {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    while (j < k && nums[k] == nums[--k]) ;
                    while (j < k && nums[j] == nums[++j]) ;
                }
            }

        }
        return new ArrayList<>(res);
    }
```

### 3.反转链表
```java
    //写递归时，不要逐步推导，套路：找到结束条件、假设前面已经处理完成、确定最新状态
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
```

## 迭代
- 实战题目不用每题必做，有思考就行了。优先完成作业
- 下周的课程周末就会放出来，周末就把视频看完。工作日只刷题和总结
- 要画思维导图，把解题套路总结出来
- 不总结等于白学