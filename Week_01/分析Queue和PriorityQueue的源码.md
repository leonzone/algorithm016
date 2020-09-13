# Queue class LinkedList

LinkedList 内部的数据结构是一个双向链表
新增（offer）和删除（poll）时间复杂度都是 O(1)
双向链表要特别处理的是：新增时链表为空和删除完成后链表为空的情况，否则会报空指针异常

# PriorityQueue class
PriorityQueue 内部的数据结构是数组

新增时，用数组维护了一个小顶堆
```java
    private void siftUpUsingComparator(int k, E x) {
        while (k > 0) {
            int parent = (k - 1) >>> 1;
            Object e = queue[parent];
            if (comparator.compare(x, (E) e) >= 0)
                break;
            queue[k] = e;
            k = parent;
        }
        queue[k] = x;
    }
```

删除时，对小顶堆的操作
```java
    private void siftDownUsingComparator(int k, E x) {
        int half = size >>> 1;
        while (k < half) {
            int child = (k << 1) + 1;
            Object c = queue[child];
            int right = child + 1;
            if (right < size &&
                comparator.compare((E) c, (E) queue[right]) > 0)
                c = queue[child = right];
            if (comparator.compare(x, (E) c) <= 0)
                break;
            queue[k] = cs;
            k = child;
        }
        queue[k] = x;
    }
```

# 其他

command+alt+鼠标左键 选择多个子类的实现