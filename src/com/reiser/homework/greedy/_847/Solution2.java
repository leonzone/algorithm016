package com.reiser.homework.greedy._847;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: reiserx
 * Date:2020/10/11
 * Des:874. 模拟行走机器人
 * https://leetcode-cn.com/problems/walking-robot-simulation/description/
 */
class Solution2 {
    public int robotSim(int[] commands, int[][] obstacles) {
        int x = 0;
        int y = 0;
        //方向
        int di = 0;
        int result = 0;

        // 用数组实现方向变化，顺时针方向
        int[][] d = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        // 将障碍物保存到 set
        Set<String> rocks = new HashSet<>();
        for (int[] obstacle : obstacles) {
            rocks.add(obstacle[0] + " " + obstacle[1]);
        }
        for (int command : commands) {
            if (command == -1) {
                di = (di + 1) % 4;
            } else if (command == -2) {
                di = (di + 3) % 4;
            } else {
                while (command-- > 0 && !rocks.contains((x + d[di][0]) + " " + (y + d[di][1]))) {
                    x += d[di][0];
                    y += d[di][1];
                }
            }
            result = Math.max(result, x * x + y * y);
        }
        return result;
    }
}
