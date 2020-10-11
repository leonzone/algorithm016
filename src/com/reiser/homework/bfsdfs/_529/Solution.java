package com.reiser.homework.bfsdfs._529;

/**
 * @author: reiserx
 * Date:2020/10/11
 * Des:529. 扫雷游戏
 * https://leetcode-cn.com/problems/minesweeper/
 */
public class Solution {
    //定义8个方向
    static int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
    static int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};

    public char[][] updateBoard(char[][] board, int[] click) {

        int x = click[0];
        int y = click[1];
        if (board[x][y] == 'M') {
            board[x][y] = 'X';
            return board;
        }

        board[x][y] = 'B';

        int count = 0;
        // 找周围 8 个 有没有炸弹
        for (int i = 0; i < 8; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            if (newX >= 0 && newX < board.length && newY >= 0 && newY < board[0].length && board[newX][newY] == 'M') {
                count++;
            }

        }

        if (count != 0) {
            board[x][y] = (char) (count + '0');
            return board;
        }

        //递归搜索8个方向相邻的节点
        for (int i = 0; i < 8; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            if (newX >= 0 && newX < board.length && newY >= 0 && newY < board[0].length && board[newX][newY] == 'E') {
                updateBoard(board, new int[]{newX, newY});
            }

        }
        return board;

    }
}
