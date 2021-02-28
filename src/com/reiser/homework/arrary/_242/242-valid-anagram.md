
## 题解
数组题目中，遇见字母。
可以使用`可以使用[s.charAt(i)-'a'] 来找到下标` 来找到下标

##
```java
public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }
        for (int i : counter) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
}
```