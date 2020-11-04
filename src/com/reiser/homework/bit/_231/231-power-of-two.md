[231. 2的幂](https://leetcode-cn.com/problems/power-of-two/)

## 题解
n  & n - 1 位运算，去掉最后一个 1
2的幂代表二进制只有一个 1
## 代码
```java
public class Solution {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}
```