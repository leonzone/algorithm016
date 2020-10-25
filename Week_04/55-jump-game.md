[55. 跳跃游戏](
https://leetcode-cn.com/problems/jump-game/)

## 题解1

判断是否能够到达最后一个位置 
转化为
从后往前看，要达到目标至少需要多少步？

## 代码1
```java
class Solution {
    public boolean canJump(int[] nums) {
        int target = nums.length - 1;
        //从后往前找
        for (int i = nums.length - 2; i >= 0; i--) {
            //目标的前面有没有能到达的
            if (i + nums[i] >= target) {
            //能到达，则自己变成目标
                target = i;
            }
        }
        return target == 0;
    }
}
```

## 题解2
遍历数组，计算每一个到达的最远距离
一旦 i 大于最远距离，证明无法到达终点。

## 代码2
```java
class Solution {
    public boolean canJump(int[] nums) {
        int maxJump=nums[0];
        for(int i=1;i<nums.length;i++){
            if(i>maxJump){
                return false;
            }
            maxJump=Math.max(maxJump,(i+nums[i]));
        }
        return true;
    }
}
```