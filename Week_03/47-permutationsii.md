https://leetcode-cn.com/problems/permutations-ii/

47. 全排列 II

```java
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] test = {1, 1, 2};
        System.out.println(solution.permute(test));
    }

    boolean[] visited;

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> perm = new ArrayList<>();
        visited = new boolean[nums.length];
        Arrays.sort(nums);
        backTrack(0, nums, perm, result);
        return result;
    }

    private void backTrack(int index, int[] nums, List<Integer> perm, List<List<Integer>> result) {
        //ter
        if (index == nums.length) {
            result.add(new ArrayList<>(perm));
            return;
        }

        // current level
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] || (i != 0 && nums[i] == nums[i - 1] && !visited[i - 1])) {
                continue;
            }
            perm.add(nums[i]);
            visited[i] = true;
            backTrack(index + 1, nums, perm, result);
            visited[i] = false;
            perm.remove(index);
        }

        // dill down

        // reset state
    }
}
```