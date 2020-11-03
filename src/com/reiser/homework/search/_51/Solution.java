package com.reiser.homework.search._51;

import java.util.*;

/**
 * @author: reiserx
 * Date:2020/11/2
 * Des:51. N 皇后
 * https://leetcode-cn.com/problems/n-queens/
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solveNQueens(8);
    }

    /**
     * 主线
     */
    Set<Integer> col;
    /**
     * 主对角线
     */
    Set<Integer> main;
    /**
     * 副对角线
     */
    Set<Integer> sub;
    List<List<String>> result;
    int n;

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        result = new ArrayList<>();
        col = new HashSet<>();
        main = new HashSet<>();
        sub = new HashSet<>();
        Deque<Integer> path = new ArrayDeque<>();
        dfs(0, path);
        return result;
    }

    private void dfs(int row, Deque<Integer> path) {
        if (row == n) {
            result.add(convert2board(path));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!col.contains(i) && !main.contains(row - i) && !sub.contains(row + i)) {
                path.add(i);
                col.add(i);
                main.add(row - i);
                sub.add(row + i);
                dfs(row + 1, path);
                sub.remove(row + i);
                main.remove(row - i);
                col.remove(i);
                path.removeLast();
            }
        }
    }

    private List<String> convert2board(Deque<Integer> path) {
        List<String> board = new ArrayList<>();
        for (Integer num : path) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[num] = 'Q';
            board.add(new String(row));
        }
        return board;
    }

}
