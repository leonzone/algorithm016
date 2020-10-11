package com.reiser.homework.greedy._847;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: reiserx
 * Date:2020/10/11
 * Des:874. 模拟行走机器人
 * https://leetcode-cn.com/problems/walking-robot-simulation/submissions/
 */
class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        int x = 0;
        int y = 0;
        int di = 0;
        int result = 0;

        int d[][] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        Set<String> ops = new HashSet<>();

        for (int[] obstacle : obstacles) {
            ops.add(obstacle[0] + " " + obstacle[1]);
        }

        for (int command : commands) {
            //   right
            if (command == -1) {
                di = (di + 1) % 4;
            } else if (command == -2) {
                di = (di + 3) % 4;
            } else {
                while (command-- > 0 && !ops.contains((x + d[di][0]) + " " + (y + d[di][1]))) {
                    x += d[di][0];
                    y += d[di][1];
                }
            }
            result = Math.max(result, x * x + y * y);
        }


        return result;

    }
}
