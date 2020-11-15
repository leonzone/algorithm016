[8. 字符串转换整数 (atoi)](https://leetcode-cn.com/problems/string-to-integer-atoi)

## 题解
难点在于细节：
- 处理空格
- 处理符号
- 判断越界

## 代码
```java
public class Solution {
    public int myAtoi(String s) {

        int index = 0;
        int result = 0;
        int sign = 1;

        if (s.length() == 0) {
            return result;
        }

        while (index < s.length() && s.charAt(index) == ' ') {
            index++;
        }

        if (index == s.length()) {
            return  0;
        }

        if (s.charAt(index) == '+' || s.charAt(index) == '-') {
            sign = s.charAt(index) == '+' ? 1 : -1;
            index++;
        }

        while (index < s.length()) {
            int di = s.charAt(index) - '0';

            if (di < 0 || di > 9) {
                break;
            }
            if (Integer.MAX_VALUE / 10 < result || (Integer.MAX_VALUE / 10 == result && Integer.MAX_VALUE % 10 < di)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            result = result * 10 + di;
            index++;
        }

        return result * sign;

    }
}
```