[322. 零钱兑换](https://leetcode-cn.com/problems/coin-change/submissions/)

## 题解
状态转移方程
```
dp[i] = Math.min(dp[i], 1 + dp[i - coin]);

dp[i - coin]+1 是不同零钱的方案

```



## 代码
```java
public class Solution2 {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        int[] coins = {1, 2, 5};
        System.out.println(solution.coinChange(coins, 11));
    }


    public int coinChange(int[] coins, int amount) {
        // dp table
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        //穷举遍历
        for (int i = 0; i < dp.length; i++) {
            for (int coin : coins) {
                if (i - coin < 0) {
                    continue;
                }
                // 状态转移方程 最优子结构
                dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }
        }
        return dp[amount];

    }

}
```