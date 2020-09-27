学习笔记

## 回溯法的理解与思考
回溯法，回溯本质就是穷举。

但过程中所谓的「归去来兮」却不好理解，这是因为回溯通常用递归来写，理解并不直观

「组合」这道题却最适合拿来理解回溯的思想

```java
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
```

主要是理解这段代码
```java
//下个时空我在前进
gener(n,k,i+1,path,result);
//这个时空我在回退
path.removeLast();
```
`gener(n,k,i+1,path,result)` 中 `k+1` 明明是在前进，而到了下一行又是 `path.removeLast()`。

可以理解为下探后的所有操作都要回退，是在无法理解就加日志

```java
System.out.println("递归之前 => " + path);
gener(n,k,i+1,path,result);
path.removeLast();
System.out.println("递归之后 => " + path);
```

可以在穷举的过程中剪枝优化,就是将无效的解和重复的解提前删除掉。

理解回溯是一方面，做题又是另一方面，多练手:

- leetcode77 [组合](https://leetcode-cn.com/problems/combinations/submissions/)
- leetcode46 [全排列](https://leetcode-cn.com/problems/permutations/)
- leetcode47 [全排列 II](https://leetcode-cn.com/problems/permutations-ii/)
- leetcode51 [N皇后](https://leetcode-cn.com/problems/n-queens/)