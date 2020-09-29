[122.买卖股票的最佳时机 II](https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/)

这道题记住结论就行,只要第二天比第一天便宜就买。
但是这个买不是真的买，而是计算到盈利里面。

```java
public class Solution {
    public int maxProfit(int[] prices) {
        int count = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                count += prices[i] - prices[i - 1];
            }
        }
        return count;

    }
}
```