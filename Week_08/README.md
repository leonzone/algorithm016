# 学习笔记

# 1.位运算
常用位运算
- 判断奇偶
```
x%2==1 -> (x&1)==1
x%2==0 -> (x&1)==0
```
- 除以2
`x/2 -> x>>1`
- 清除最低位的 1
`X=X&(X-1)`
- 得到最地位的 1
`X&-X`
- X&~X=>0

# 2.布隆过滤器 和 LRU

## 布隆过滤器

- 判断有一个0 就不存在，且一定不存在
- 判断全为 1 则可能存在

### 应用
布隆过滤器+DB
布隆过滤器只是挡在前面，快速判断元素不存在在数据库

### 实现
```java
public class BloomFilter {
    private BitSet hashes;
    private RandomInRange prng;
    private int k;
    private static final double LN2 = 0.6931471805599453; // ln(2)


    public BloomFilter(int n, int m) {
        k = (int) Math.round(LN2 * m / n);
        if (k <= 0) {
            k = 1;
        }
        this.hashes = new BitSet(m);
        this.prng = new RandomInRange(m, k);
    }

    public void add(Object o) {
        prng.init(o);
        for (RandomInRange r : prng) {
            hashes.set(r.value);
        }
    }

    public boolean contains(Object o) {
        prng.init(o);
        for (RandomInRange r : prng) {
            if (!hashes.get(r.value)) {
                return false;
            }
        }
        return true;
    }


    private static class RandomInRange
            implements Iterable<RandomInRange>, Iterator<RandomInRange> {

        private Random prng;
        private int max; // Maximum value returned + 1
        private int count; // Number of random elements to generate
        private int i = 0; // Number of elements generated
        public int value; // The current value

        RandomInRange(int maximum, int k) {
            max = maximum;
            count = k;
            prng = new Random();
        }

        public void init(Object o) {
            prng.setSeed(o.hashCode());
        }

        @Override
        public Iterator<RandomInRange> iterator() {
            i = 0;
            return this;
        }

        @Override
        public RandomInRange next() {
            i++;
            value = prng.nextInt() % max;
            if (value < 0) value = -value;
            return this;
        }

        @Override
        public boolean hasNext() {
            return i < count;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}

```

## LRU
最近使用

### 实现1
HashTable +Double lindkedList
```java
class LRUCache2 extends LinkedHashMap<Integer, Integer> {
    static class DLinkNode {
        int value;
        int key;
        DLinkNode pre;
        DLinkNode next;

        DLinkNode() {
        }

        DLinkNode(int key, int value) {
            this.key = key;
            this.value = value;
        }

    }

    private Map<Integer, DLinkNode> cache = new HashMap<>();
    int size;
    int capacity;
    DLinkNode head;
    DLinkNode tail;

    public LRUCache2(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        head = new DLinkNode();
        tail = new DLinkNode();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        DLinkNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        // 如果 key 存在，先通过哈希表定位，再移到头部
        moveToHead(node);
        return node.value;

    }

    public void put(int key, int value) {
        DLinkNode node = cache.get(key);
        // 如果之前不存在
        if (node == null) {
            DLinkNode newNode = new DLinkNode(key, value);
            //放到 hash 表中
            cache.put(key, newNode);
            //放到头部
            addToHead(newNode);
            size++;
            //查过 capacity，移除最后一个
            if (size > capacity) {
                DLinkNode tail = removeTail();
                // 删除哈希表中对应的项
                cache.remove(tail.key);
                size--;
            }
        } else {
            node.value = value;
            moveToHead(node);
        }

    }


    private void addToHead(DLinkNode node) {
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
    }

    private void removeNode(DLinkNode node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    private void moveToHead(DLinkNode node) {
        removeNode(node);
        addToHead(node);
    }

    private DLinkNode removeTail() {
        DLinkNode node = tail.pre;
        removeNode(node);
        return node;

    }

}

```

### 实现2
LinkedHashMap 本身就实现了 LRUCache
```java
class LRUCache extends LinkedHashMap<Integer, Integer> {
    private int capacity;

    public LRUCache(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }
}

```


# 3.排序
## 高级排序
时间复杂度为 O(N*LogN)

### 快速排序
先找到一个锚点，使得左子数组都小于锚点，右子数组都大于锚点，然后对左右子数组排序

```java
public class QuickSort {
    public void sort(int[] array, int begin, int end) {
        if (end <= begin) {
            return;
        }
        int pivot = partition(array, begin, end);
        sort(array, begin, pivot - 1);
        sort(array, pivot + 1, end);
    }

    private int partition(int[] a, int begin, int end) {
        int counter = begin;
        int pivot = end;

        for (int i = begin; i < end; i++) {
            if (a[i] < a[pivot]) {
                int tmp = a[i];
                a[i] = a[counter];
                a[counter] = tmp;
                counter++;
            }
        }
        int temp = a[pivot]; a[pivot] = a[counter]; a[counter] = temp;

        return counter;
    }
}
```

### 合并排序

和快排类似，但步骤相反：先排序左右子数组，再合并两个有序子数组

```java
public class MergeSort {

    public void sort(int[] array, int begin, int end) {
        if (end <= begin) {
            return;
        }
        int mid = begin + ((end - begin) >> 1);
        sort(array, begin, mid);
        sort(array, mid + 1, end);
        merge(array, begin, mid, end);
    }

    private void merge(int[] array, int left, int mid, int right) {
        int[] tmp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;

        while (i <= mid && j <= right) {
            tmp[k++] = array[i] < array[j] ? array[i++] : array[j++];
        }

        while (i <= mid) {
            tmp[k++] = array[i++];
        }

        while (j <= right) {
            tmp[k++] = array[j++];
        }

        System.arraycopy(tmp, 0, array, left, tmp.length);
    }
}
```

### 堆排序

使用小顶堆实现
```java
public class HeapSort {
    public void sort(int[] array) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i : array) {
            queue.add(i);
        }
        for (int i = 0; i < array.length && queue.size() > 0; i++) {
            array[i] = queue.poll();
        }
    }
}
```

