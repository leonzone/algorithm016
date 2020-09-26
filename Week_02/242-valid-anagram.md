https://leetcode-cn.com/problems/valid-anagram/description/

有效的字母异位词

```java
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        Map<Character,Integer> map=new HashMap<>();
        for(int i =0; i<s.length();i++){

            char s_char = s.charAt(i);
            int count=map.getOrDefault(s_char,0);
            map.put(s_char,++count);

            char t_char = t.charAt(i);
            int count2=map.getOrDefault(t_char,0);
            map.put(s_char,--count2);
        }

        for (Integer value : map.values()) {
            if(value!=0){
                return false;
            }
        }

        return true;
    }
}
```