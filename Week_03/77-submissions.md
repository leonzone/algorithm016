77.[组合](https://leetcode-cn.com/problems/combinations/submissions/)

回溯法，回溯就是穷举，可以在穷举的过程中剪枝优化

使用回溯法的招数就是在递归中 先向下探，当递归调用之后，又向上回退（回溯）
在下层前进，在本层回退


```java
public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (k <= 0 || n < k) {
            return res;
        }
        //使用队列是因为需要重复使用
        Deque<Integer> tmp = new ArrayDeque<>();
        gener(n, k, 1, tmp, res);
        return res;
    }
    //begin 是访问的层级
    private void gener(int n, int k, int begin, Deque<Integer> path, List<List<Integer>> result) {
        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }
        //int i = begin; i <= n - (k - path.size()) + 1 剪枝操作
        for (int i = begin; i <= n - (k - path.size()) + 1; i++) {
            path.addLast(i);
            //下个时空我在前进
            gener(n,k,i+1,path,result);
            //这个时空我在回退
            path.removeLast();

        }
    }

}
```