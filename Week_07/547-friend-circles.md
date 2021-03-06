[547. 朋友圈](https://leetcode-cn.com/problems/friend-circles/)

## 题解
并查集适合解决交集的问题

## 代码
```java
public class Solution {
    public int findCircleNum(int[][] M) {
        int m = M.length;
        UnionFind unionFind = new UnionFind(m);

        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[0].length; j++) {
                if (M[i][j] == 1) {
                    unionFind.union(i, j);
                }
            }
        }

        return unionFind.count;

    }
}

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
            parent[p] = parent[parent[p]];
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
        return;
    }
}
```