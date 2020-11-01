package com.reiser.homework.trie._130;

/**
 * @author: reiserx
 * Date:2020/11/1
 * Des:130. 被围绕的区域
 * https://leetcode-cn.com/problems/surrounded-regions/
 */
public class Solution {
    private int rows;
    private int cols;

    public void solve(char[][] board) {
        rows = board.length;
        if (rows == 0) {
            return;
        }
        cols = board[0].length;
        UnionFind uf = new UnionFind(rows * cols + 1);
        int dummyNode = rows * cols;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O') {
                    // 遇到O进行并查集操作合并
                    if (i == 0 || i == rows - 1 || j == 0 || j == cols - 1) {
                        // 边界上的O,把它和dummyNode 合并成一个连通区域.
                        uf.union(index(i, j), dummyNode);
                    } else {
                        // 和上下左右合并成一个连通区域.
                        if (board[i - 1][j] == 'O') {
                            uf.union(index(i, j), index(i - 1, j));
                        }
                        if (i < rows - 1 && board[i + 1][j] == 'O') {
                            uf.union(index(i, j), index(i + 1, j));
                        }
                        if (board[i][j - 1] == 'O') {
                            uf.union(index(i, j), index(i, j - 1));
                        }
                        if (j < cols - 1 && board[i][j + 1] == 'O') {
                            uf.union(index(i, j), index(i, j + 1));
                        }
                    }
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (uf.isConnected(index(i, j), dummyNode)) {
                    // 和dummyNode 在一个连通区域的,那么就是O；
                    board[i][j] = 'O';
                } else {
                    board[i][j] = 'X';
                }
            }
        }


    }

    int index(int i, int j) {
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

        public boolean isConnected(int p, int q) {
            return find(p) == find(q);
        }
    }
}
