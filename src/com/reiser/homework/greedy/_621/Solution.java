package com.reiser.homework.greedy._621;

import java.util.Arrays;

/**
 * @author: reiserx
 * Date:2020/10/22
 * Des:621. 任务调度器
 * https://leetcode-cn.com/problems/task-scheduler
 */
public class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] map = new int[26];
        for (char task : tasks) {
            map[task - 'A']++;
        }
        Arrays.sort(map);
        int maxValue = map[25] - 1;
        int reminder = maxValue * n;

        for (int i = map.length - 1; i >= 1; i--) {
            reminder -= Math.min(map[i], maxValue);
            if(map[i]==0){
                break;
            }
        }

        return reminder > 0 ? reminder + tasks.length : tasks.length;
    }
}
