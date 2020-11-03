package com.reiser.homework.search._36;

/**
 * @author: reiserx
 * Date:2020/11/2
 * Des:36. 有效的数独
 * https://leetcode-cn.com/problems/valid-sudoku/
 */
public class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[][] row = new int[9][10];
        int[][] col = new int[9][10];
        int[][] box = new int[9][10];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }

                int currNum = board[i][j] - '0';
                int[] box1 = box[j / 3 + i / 3 * 3];
                if (row[i][currNum] > 0 || col[j][currNum] > 0 || box1[currNum] > 0) {
                    return false;
                }
                row[i][currNum]++;
                col[j][currNum]++;
                box1[currNum]++;
            }
        }
        return true;
    }
}
