[位1的个数](https://leetcode-cn.com/problems/number-of-1-bits/)

## 题解
n  & n - 1 位运算，去掉最后一个 1
## 代码
```java
public class Solution {
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n &= n - 1;
        }
        return count;
    }
}
```