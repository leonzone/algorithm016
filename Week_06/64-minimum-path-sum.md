[64. 最小路径和](https://leetcode-cn.com/problems/minimum-path-sum/submissions/)

## 题解
动态规划
- 子问题
    `f(i)(j)=a[i]+min(f(i-1)(j),f(i)(j-1))`
- dp数组
    `int[][] grid`
- dp方程
    `g[i][j]=a[i]+min(g[i-1][j],g[i][j-1])`    

## 代码
```java
public class Solution {
    public int minPathSum(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                if (i == 0) {
                    grid[0][j] = grid[0][j] + grid[0][j - 1];
                } else if (j == 0) {
                    grid[i][0] = grid[i][0] + grid[i - 1][0];
                } else {
                    grid[i][j] = grid[i][j] + Math.min(grid[i - 1][j], grid[i][j - 1]);
                }
            }
        }
        return grid[grid.length-1][grid[0].length-1];
    }
}
```