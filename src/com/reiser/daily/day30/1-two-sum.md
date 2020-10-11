[1.两数之和](https://leetcode-cn.com/problems/two-sum/description/)

## 题解


## 代码

```java
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> tagets = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int t = target - nums[i];
            if (tagets.containsKey(t)) {
                return new int[]{tagets.get(t), i};
            }
            tagets.put(nums[i], i);
        }
        return null;
    }
}
```