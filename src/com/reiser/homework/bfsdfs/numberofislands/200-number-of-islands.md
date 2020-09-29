[200. 岛屿数量](https://leetcode-cn.com/problems/number-of-islands/)

解题
1. 遍历去找岛
2. 找到后把相邻的陆地全部炸平（1->0）


代码
```java
public class Solution {
    public int numIslands(char[][] grid) {
        //初始化变量
        int n = grid.length;
        if (n == 0) {
            return 0;
        }
        int count = 0;
        int m = grid[0].length;
        //遍历去找岛
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    //找到后把相邻的陆地全部炸平（1->0）
                    dfsMarking(grid, i, j);
                }
            }
        }
        return count;
    }

    private void dfsMarking(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != '1') {
            return;
        }
        grid[i][j] = '0';
        dfsMarking(grid, i - 1, j);
        dfsMarking(grid, i + 1, j);
        dfsMarking(grid, i, j - 1);
        dfsMarking(grid, i, j + 1);
    }
}
```