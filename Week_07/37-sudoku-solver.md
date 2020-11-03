[37. 解数独](https://leetcode-cn.com/problems/sudoku-solver/)

## 题解

## 代码
```java
public class Solution {
    public void solveSudoku(char[][] board) {
        backtrack(board, 0, 0);
    }

    private boolean backtrack(char[][] board, int i, int j) {
        int m = 9;
        int n = 9;
        //循环到最后一列，到下一行
        if (j == n) {
            return backtrack(board, i + 1, 0);
        }

        //找到一个可行解，立刻返回
        if (i == m) {
            return true;
        }
        //如果有值则不需要穷举
        if (board[i][j] != '.') {
            return backtrack(board, i, j + 1);
        }

        for (char ch = '1'; ch <= '9'; ch++) {
            if (!isValid(board, i, j, ch)) {
                continue;
            }

            board[i][j] = ch;
            // 如果找到一个可行解，立即结束
            if (backtrack(board, i, j + 1)) {
                return true;
            }
            board[i][j] = '.';

        }
        // 穷举完 1~9，依然没有找到可行解，此路不通
        return false;

    }

    // 判断 board[i][j] 是否可以填入 n
    boolean isValid(char[][] board, int r, int c, char n) {
        for (int i = 0; i < 9; i++) {
            // 判断行是否存在重复
            if (board[r][i] == n) {
                return false;
            }
            // 判断列是否存在重复
            if (board[i][c] == n) {
                return false;
            }
            // 判断 3 x 3 方框是否存在重复
            if (board[(r / 3) * 3 + i / 3][(c / 3) * 3 + i % 3] == n) {
                return false;
            }
        }
        return true;
    }
}
```