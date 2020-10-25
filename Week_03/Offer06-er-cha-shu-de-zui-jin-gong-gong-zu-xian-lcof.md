[剑指 Offer 68 - 二叉树的最近公共祖先](https://leetcode-cn.com/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof)


## 题解：


最近公共祖先-->当 p、q 节点位于 root 节点的 两侧时，我们称 root 是 p q 的公共祖先

递归代码：

左侧没有找到，说明 p q 都在右侧
右侧没有找到，说明 p q 都在左侧
左右都找到了，说明 root 就是公共祖先


## 代码
```java
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        // terminator
        if (root == null || root == p || root == q) {
            return root;
        }
        // process current logic
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        //左侧没找到，p q 都在右侧
        if (left == null) {
            return right;
        }
        //右侧没找到，p q 都在左侧
        if (right == null) {
            return left;
        }
        // p q 在异侧，则 root 为公共祖先
        return root;
        // drill down
        // restore current status
    }
}
```