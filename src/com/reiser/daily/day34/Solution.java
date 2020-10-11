package com.reiser.daily.day34;

/**
 * @author: reiserx
 * Date:2020/10/11
 * Des:74. 搜索二维矩阵
 * https://leetcode-cn.com/problems/search-a-2d-matrix/
 */
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int m = matrix.length;
        if (m == 0) {
            return false;
        }
        int n = matrix[0].length;
        int high = m * n - 1;
        int low = 0;

        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            int midValue = matrix[mid / n][mid % n];
            if (midValue == target) {
                return true;
            } else if (midValue > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return false;
    }
}
