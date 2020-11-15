[746. 使用最小花费爬楼梯](https://leetcode-cn.com/problems/min-cost-climbing-stairs/)

## 题解
因为一次可以走一步或者两步，那么 `dp[i]=Math.min(dp[[i-1],dp[i-2]])+cost[i]`

注意：最后一步时需要在 length-1 和 length-2 之间做选择

## 代码1
最直接的写法

```java
public class Solution {
    public int minCostClimbingStairs(int[] cost) {
        
        int n = cost.length;
        int[] dp = new int[n];
        dp[0] = cost[0];
        dp[1] = cost[1];

        for (int i = 2; i < cost.length; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
        }

        return Math.min(dp[n - 1], dp[n - 2]);

    }
}

```

## 代码2
可以直接利用cost数组，原地计算

```java
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        for (int i = 2; i < cost.length; i++) {
            cost[i] = Math.min(cost[i - 1], cost[i - 2]) + cost[i];
        }
        return Math.min(cost[cost.length - 1], cost[cost.length - 2]);

    }
}
```