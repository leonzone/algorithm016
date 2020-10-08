package com.reiser.homework.greedy._860;

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
            if (bill == 5) { five++; }
            else if (bill == 10) {ten++;five--;}
            else if(ten>0){ten--;five--;}
            else{five-=3;}
            if(five<0) {return false;}
        }
        return true;
    }
}
