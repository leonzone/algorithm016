https://leetcode-cn.com/problems/chou-shu-lcof/

剑指 Offer 49. 丑数

```java
class Solution {
    int[] uglynums = {2, 3, 5};

    public int nthUglyNumber(int n) {

        PriorityQueue<Long> heap = new PriorityQueue<>();
        heap.add(1L);
        int count = 0;
        while (!heap.isEmpty()) {
            long c = heap.poll();
            // if (heap.size() > n) {
            //     return (int) c;
            // }
             if(++count >= n){
                return (int) c;
            }

            for (int num : uglynums) {
                long tmp = c * num;
                if (!heap.contains(tmp)) {
                    heap.add(tmp);
                }
            }
        }
        return -1;
    }
}
```