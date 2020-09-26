https://leetcode-cn.com/problems/top-k-frequent-elements/

前 K 个高频元素

```java
public class Solution {
    public static void main(String[] args) {
        Solution solution=new Solution();
        int[] nums={-1,-1};
        int[] r=solution.topKFrequent(nums,1);
        for (int i : r) {
            System.out.println(i);
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        //定义大顶堆
        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> a, Map.Entry<Integer, Integer> b) {
                return b.getValue() - a.getValue();
            }
        });

        maxHeap.addAll(map.entrySet());

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i]=maxHeap.poll().getKey();
        }
        return result;

    }
}
```