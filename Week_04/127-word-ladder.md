[127. 单词接龙](https://leetcode-cn.com/problems/word-ladder/)

题解

代码
```java
public class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Map<String, List<String>> dict = new HashMap<>(wordList.size());
        int length = beginWord.length();
        // 以 hit 为例 构建一个以 *it、h*t、hi* 为 key 的字典，并把想同 key 的字符串放到同一个 list 里面
        wordList.forEach(word -> {
            for (int i = 0; i < length; i++) {
                //生成通用的 key hit -> h*t <- hot
                String comboWord = word.substring(0, i) + "*" + word.substring(i + 1, length);
                List<String> comboList = dict.getOrDefault(comboWord, new ArrayList<>());
                comboList.add(word);
                dict.put(comboWord, comboList);
            }
        });
        // BFS 的特点，会使用一个队列记录，每层的情况
        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        queue.add(new Pair<>(beginWord, 1));
        // 记录访问的 node 减少计算
        visited.add(beginWord);
        while (!queue.isEmpty()) {
            Pair<String, Integer> node = queue.poll();
            String curWord = node.getKey();
            int level = node.getValue();
            for (int i = 0; i < length; i++) {
                //生成通用的 key hit -> h*t <- hot
                String comboWord = curWord.substring(0, i) + "*" + curWord.substring(i + 1, length);
                List<String> comboList = dict.getOrDefault(comboWord, new ArrayList<>());
                for (String word : comboList) {
                    if (word.equals(endWord)) {
                        return level + 1;
                    }

                    if (!visited.contains(word)) {
                        // 每完成一层的遍历， level+1
                        queue.add(new Pair<>(word, level + 1));
                        visited.add(word);
                    }
                }

            }

        }
        return -1;

    }
}
```