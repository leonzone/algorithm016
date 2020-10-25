package com.reiser.homework.bfsdfs._200;

/**
 * @author: reiserx
 * Date:2020/9/30
 * Des:
 */
public class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        if (m == 0) {
            return m;
        }

        int n = grid[0].length;
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //找到一个
                if (grid[i][j] == '1') {
                    count++;
                    //标记周围的路径
                    dfsMarking(grid, i, j);
                }
            }
        }
        return count;

    }

    //标记周围的路径为 0
    public void dfsMarking(char[][] grid, int i, int j) {
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
