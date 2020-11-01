# 学习笔记


## Trie 树
26叉树，若节点不是单词则为前缀，用于字符串搜索
利用字符串的公共前缀来降低查询时间的开销以达到提高效率的目的。

### 代码模版
```java
class Trie {

    public boolean isWord = false;
    public String val;
    public Trie[] next = new Trie[26];

    public Trie() {
    }
    //插入单词
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
    //查找单词
    public boolean search(String word) {
        Trie root = this;
        char w[] = word.toCharArray();
        for (int i = 0; i < w.length; ++i) {
            if (root.next[w[i] - 'a'] == null) {
                return false;
            }
            root = root.next[w[i] - 'a'];
        }
        return root.isWord;
    }
    //查找前缀
    public boolean startsWith(String prefix) {
        Trie root = this;
        char p[] = prefix.toCharArray();
        for (int i = 0; i < p.length; ++i) {
            if (root.next[p[i] - 'a'] == null) {
                return false;
            }
            root = root.next[p[i] - 'a'];
        }
        return true;
    }
}
```
## 并查集
适用于 组团、配对问题
- makeSet(s)：建立一个新的并查集，其中包含 s 个单元素集合。
- unionSet(x, y)：把元素 x 和元素 y 所在的集合合并，要求 x 和 y 所在 的集合不相交，如果相交则不合并。
- ﬁnd(x)：找到元素 x 所在的集合的代表，该操作也可以用于判断两个元 素是否位于同一个集合，只要将它们各自的代表比较一下就可以了。

```java
class UnionFind {
    int[] parent;
    int count;

    public UnionFind(int n) {
        parent = new int[n];
        count = n;
        for (int i = 0; i < n; i++) {
            parent[i] = i;

        }
    }

    public int find(int p) {
        while (p != parent[p]) {
            //压缩路径操作
            parent[p] = parent[parent[p]];
            //向上一层找
            p = parent[p];
        }

        return p;
    }

    public void union(int p, int q) {
        int unionP = find(p);
        int unionQ = find(q);
        if (unionP == unionQ) {
            return;
        }
        parent[unionP] = unionQ;
        count--;
    }
}
```

## AVL 树
**平衡二叉搜索树**
左子树的高度减去它的右子树的高度大于 1 时，会进行旋转到达平衡

## 红黑树
**一种近似平衡的二叉搜索树**
从根到叶子的最长的可能路径不多于最短的可能路径的两倍长。


## 题目

| 编号| leetcode 连接 | 题目（题解） |
|-----|----|----|
|   70  | [爬楼梯](https://leetcode-cn.com/problems/climbing-stairs/) |  [dp](./70-climbing-stairs.md)  |
|   208  | [实现 Trie (前缀树)](https://leetcode-cn.com/problems/implement-trie-prefix-tree/)|  [Trie](./208-implement-trie-prefix-tree.md)  |
|   547  | [朋友圈](https://leetcode-cn.com/problems/friend-circles/)|  [Trie](./547-friend-circles.md)  |
|   200  | [岛屿数量](https://leetcode-cn.com/problems/number-of-islands/)|  [Trie](./200-number-of-islands.md)  |
|   130  | [被围绕的区域](https://leetcode-cn.com/problems/surrounded-regions/)|  [Trie](./130-surrounded-regions.md)  |
|   212  | [单词搜索 II](https://leetcode-cn.com/problems/word-search-ii)|  [Trie](./212-word-search-ii.md)  |