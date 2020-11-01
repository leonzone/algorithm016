[212.单词搜索 II](https://leetcode-cn.com/problems/word-search-ii)

## 题解
字典树 + dfs

## 代码

```java
public class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        //构建 Trie
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        //使用 set 避免重复
        Set<String> result = new HashSet<>();
        int m = board.length;
        int n = board[0].length;
        //遍历去找
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, i, j, trie, result);
            }
        }
        return new ArrayList<>(result);
    }
    // 使用方向数组简化代码
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    /**
     * @param node Trie
     * @param result 保存的结果
     */
    private void dfs(char[][] board, int i, int j, Trie node, Set<String> result) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] == '@') {
            return;
        }
        node = node.next[board[i][j] - 'a'];
        if (node == null) {
            return;
        }
        //发现为字符串时，加入到结果。不要返回，因为有 aaa 和 aaab 的情况
        if (node.isWord) {
            result.add(node.val);
        }

        char tmp = board[i][j];
        //使用占位符，避免重复访问
        board[i][j] = '@';
        //遍历上下左右
        for (int k = 0; k < 4; k++) {
            dfs(board, i + dx[k], j + dy[k], node, result);
        }
        //使用占位符，记得要恢复
        board[i][j] = tmp;

    }
}

class Trie {
    public boolean isWord = false;
    public String val;
    public Trie[] next = new Trie[26];

    public Trie() {
    }

    public void insert(String word) {
        Trie root = this;
        char w[] = word.toCharArray();
        for (int i = 0; i < w.length; ++i) {
            if (root.next[w[i] - 'a'] == null) {
                root.next[w[i] - 'a'] = new Trie();
            }
            root = root.next[w[i] - 'a'];
        }
        root.isWord = true;
        root.val = word;
    }

}

```