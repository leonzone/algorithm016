46. [全排列](https://leetcode-cn.com/problems/permutations/)

## 题解
回溯算法


## 代码

```java
public class Solution {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> output = new ArrayList<>();
        for (int num : nums) {
            output.add(num);
        }
        backTrack(0, nums.length, output, result);
        return result;
    }

    private void backTrack(int first, int length, List<Integer> output, List<List<Integer>> result) {
        //ter
        if (first == length) {
            result.add(new ArrayList<>(output));
            return;
        }

        // current level
        for (int i = first; i < output.size(); i++) {
            Collections.swap(output, first, i);
            backTrack(i, length, output, result);
            Collections.swap(output, first, i);
        }

        // dill down

        // reset state
    }
}
```