[42. 接雨水](https://leetcode-cn.com/problems/trapping-rain-water/)

## 题解
1. 维护一个单调递减的栈，遇见比自己高的柱子，说明可以接雨水了，即开始计算。
2. 雨水的面积是一层一层的求和，一层的`面积= 宽 x 高`；`宽 = 下标之差-1`；`高 = 两柱较矮者 - 中间柱子的高度`

## 代码
```java
public class Solution {
    public int trap(int[] height) {
        int sum = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < height.length; i++) {
            //如果栈不空并且当前指向的高度大于栈顶高度就一直循环
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int h = height[stack.pop()];
                if (stack.isEmpty()) {
                    break;
                }
                //两堵墙之前的距离。
                int distance = i - stack.peek() - 1;
                // height[stack.peek()] 是左墙的高度，height[i] 是右墙的高度，取矮的那个
                int min = Math.min(height[stack.peek()], height[i]);
                sum = sum + distance * (min - h);
            }
            stack.push(i);
        }
        return sum;
    }
}    
```