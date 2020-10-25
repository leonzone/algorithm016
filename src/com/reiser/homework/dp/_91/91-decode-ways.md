[91. 解码方法](https://leetcode-cn.com/problems/decode-ways/submissions/)

## 题解

核心的状态转移转移方程:f(n)=f(n-1)+f(n-2) 
原因：'x25' x2+5=>f(n-1) 和 x+25=>f(n-2)
和爬楼梯是一样的，只是有特殊情况

```
10
20
x < 10
x > 26
30
```

## 代码
```java
public class Solution {
    public int numDecodings(String s) {
        if (s.startsWith("0")) {
            return 0;
        }
        int pre = 1;
        int curr = 1;

        for (int i = 1; i < s.length(); i++) {
            int tmp = curr;

            if (s.charAt(i) == '0') {
                if (s.charAt(i-1) == '1' || s.charAt(i-1) == '2') {
                    curr = pre;
                } else {
                    return 0;
                }
            } else if (s.charAt(i - 1) == '1' || (s.charAt(i - 1) == '2' && s.charAt(i) > '0' && s.charAt(i) < '7')) {
                curr = curr + pre;
            }
            pre = tmp;
        }
        return curr;

    }
}
```
