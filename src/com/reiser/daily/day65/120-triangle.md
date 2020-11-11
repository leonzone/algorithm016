[120. 三角形最小路径和](https://leetcode-cn.com/problems/triangle/)

## 题解
```
[
[2],
[3,4],
[6,5,7],
[4,1,8,3]
]
相邻结点：与(i, j) 点相邻的结点为 (i + 1, j) 和 (i + 1, j + 1)。
```

从下往上找最短路径

## 代码1
```java
public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {

        int n = triangle.size();
        int[][] dp = new int[n + 1][n + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
            }

        }
        return dp[0][0];
    }
}
```
- 时间复杂度：O(N^2)，N 为三角形的行数。
- 空间复杂度：O(N^2)，N 为三角形的行数。

## 代码2 

因为计算最优值时只用到了 j 和 j+1，所以 dp 可以简化为一维数组，但还是第一个解法更典型

```java
public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {

        int n = triangle.size();
        int[] dp = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                // 简化后的 dp 数组
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }

        }
        return dp[0];
    }
}
```
- 时间复杂度：O(N^2)，N 为三角形的行数。
- 空间复杂度：O(N)，N 为三角形的行数。
