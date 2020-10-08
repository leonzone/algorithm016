package com.reiser.daily.day27;

/**
 * @author: reiserx
 * Date:2020/10/3
 * Des:367. 有效的完全平方数
 */
public class Solution {
    public boolean isPerfectSquare(int num) {
        int low = 0;
        int high = num - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (mid == num / mid && (num % mid == 0)) {
                return true;
            } else if (mid > (num / mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return false;

    }
}
