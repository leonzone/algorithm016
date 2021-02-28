[389. 找不同](https://leetcode-cn.com/problems/find-the-difference/)

## 题解

求两个集合的交集，
1. hashmap,第一个字母遍历依次放入hashmap，并加1；第二个字母遍历依次取出并减1，为 -1 时为结果
2. 因为是字母，用26位的数组代替 hashmap
3. 位运算

## 代码
```java
class Solution {
    public char findTheDifference(String s, String t) {
        char res = 0;
        for (char c: s.toCharArray()) {
            res ^= c;
        }
        for (char c: t.toCharArray()) {
            res ^= c;
        }
        return res;

    }
}
```