package com.reiser.homework.greedy.lemonadechange;

/**
 * @author: reiserx
 * Date:2020/9/29
 * Des:柠檬水找零
 * https://leetcode-cn.com/problems/lemonade-change/description/
 */
public class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        for (int bill : bills) {
            if (bill == 5) {
                five++;
            } else if (bill == 10) {
                if (five > 0) {
                    five--;
                    ten++;
                } else {
                    return false;
                }
            } else {
                if (ten > 0 && five > 0) {
                    ten--;
                    five--;
                } else if (five >= 3) {
                    five -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
