# Hash table 经典答案整理

## 1 TwoSum


## 49 [GroupAnagrams](https://leetcode-cn.com/problems/group-anagrams/])

字母异位词分组,固定的解法就是适用 map 构建 
```java
{
  {k1,{v11,v12,v13},
  {k2,{v21}
}
```

**方法1**
```java
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String keyStr = String.valueOf(ca);
            if (!map.containsKey(keyStr)) map.put(keyStr, new ArrayList<>());
            map.get(keyStr).add(s);
        }
        return new ArrayList<>(map.values());
    }
```
时间复杂度：为O(NKlogK),K 为字符的长度
空间复杂度：为O(NK)

**方法2**
方法2是优化了key，使得key不用排序也能生成
```java
    int[] counter   =   new int[26];
    for(char ch : s.toCharArray()){
        counter[ch - 'a']++;
    }
    
    return Arrays.hashCode(counter)
```

```java
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] ca = new char[26];
            for (char c : s.toCharArray()) ca[c - 'a']++;
            String keyStr = String.valueOf(ca);
            if (!map.containsKey(keyStr)) map.put(keyStr, new ArrayList<>());
            map.get(keyStr).add(s);
        }
        return new ArrayList<>(map.values());
    }
```
时间复杂度：为O(NK),K 为字符的长度
空间复杂度：为O(NK)