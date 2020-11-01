package com.reiser.homework.trie._200;

/**
 * @author: reiserx
 * Date:2020/11/1
 * Des:200. 岛屿数量
 * https://leetcode-cn.com/problems/number-of-islands/
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] grid = {{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}};
        System.out.println(solution.numIslands(grid));
    }

    private int rows;
    private int cols;


    public int numIslands(char[][] grid) {
        rows = grid.length;
        if (rows == 0) {
            return 0;
        }
        cols = grid[0].length;
        UnionFind unionFind = new UnionFind(rows * cols);
        int spaces = 0;
        int[][] directions = {{1, 0}, {0, 1}};
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '0') {
                    spaces++;
                } else {
                    for (int[] direction : directions) {
                        int newX = i + direction[0];
                        int newY = j + direction[1];
                        // 检查右一格和下一格是否为陆地
                        if (newX < rows && newY < cols && grid[newX][newY] == '1') {
                            unionFind.union(getIndex(i, j), getIndex(newX, newY));
                        }
                    }
                }

            }
        }

        return unionFind.count - spaces;
    }

    private int getIndex(int i, int j) {
        return i * cols + j;
    }

    class UnionFind {
        int[] parent;
        int count;

        public UnionFind(int n) {
            parent = new int[n];
            count = n;
            for (int i = 0; i < n; i++) {
                parent[i] = i;

            }
        }

        public int find(int p) {
            while (p != parent[p]) {
                parent[p] = parent[parent[p]];
                p = parent[p];
            }

            return p;
        }

        public void union(int p, int q) {
            int unionP = find(p);
            int unionQ = find(q);

            if (unionP == unionQ) {
                return;
            }
            parent[unionP] = unionQ;
            count--;
        }
    }
}



