package com.reiser.homework.bfsdfs.numberofislands;

/**
 * @author: reiserx
 * Date:2020/9/30
 * Des:
 */
public class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        if (n == 0) {
            return 0;
        }
        int count = 0;
        int m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    count++;
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
