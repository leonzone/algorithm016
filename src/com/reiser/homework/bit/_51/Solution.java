package com.reiser.homework.bit._51;

import java.util.*;

/**
 * @author: reiserx
 * Date:2020/11/4
 * Des:
 */
public class Solution {
    List<List<String>> result;
    int n;

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        result = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        dfs(path, 0, 0, 0, 0);
        return result;
    }

    private void dfs(Deque<Integer> path, int row, int col, int pie, int na) {
        if (row == n) {
            result.add(convert2board(path));
            return;
        } else {
            int availablePositions = ((1 << n) - 1) & (~(col | pie | na));
            while (availablePositions != 0) {
                int position = availablePositions & (-availablePositions);
                availablePositions = availablePositions & (availablePositions - 1);
                int column = Integer.bitCount(position - 1);
                path.add(column);
                dfs(path, row + 1, col | position, (pie | position) << 1, (na | position) >> 1);
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
