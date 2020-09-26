

# 347. [Top K Frequent Elements](https://leetcode.com/problems/top-k-frequent-elements/)
去最大 K 个元素

## 方法1
Map 做汇总，汇总之后用优先队列构建大顶堆，然后取前 k 个

### 复杂度
时间复杂度：O(Nlogk)
空间复杂度：O(N)

### 实现代码

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
## 方法2
Map 做汇总，使用数组下标表示优先级

### 复杂度
时间复杂度：O(N)
空间复杂度：O(N)

### 实现代码

```java
public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
    
        List<Integer>[] bucket = new List[nums.length + 1];
        Map<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();
    
        for (int n : nums) {
            frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
        }
    
        for (int key : frequencyMap.keySet()) {
            int frequency = frequencyMap.get(key);
            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }
    
        List<Integer> res = new ArrayList<>();
    
        for (int pos = bucket.length - 1; pos >= 0 && res.size() < k; pos--) {
            if (bucket[pos] != null) {
                res.addAll(bucket[pos]);
            }
        }
        return res.toArray();
    }
}
```