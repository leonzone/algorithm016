[45. 跳跃游戏 II](
https://leetcode-cn.com/problems/jump-game-ii/)

解题：
使用贪心解法，每次都取最远的距离，这样一定能覆盖之前的局部最优方案



代码：

```java
public class Solution {

    public int jump(int[] nums) {
        int count = 0;
        //可以达到的最大位置
        int maxPostion = 0;
        //本次循环的最终位置
        int end = 0;
        //不循环最后一个，是因为最后一位一定能达到
        for (int i = 0; i < nums.length - 1; i++) {
            maxPostion = Math.max(maxPostion, i + nums[i]);
            //上一次的最优方案被更新
            if (i == end) {
                end = maxPostion;
                count++;
            }
        }
        return count;
    }
}
```