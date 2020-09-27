https://leetcode-cn.com/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof

剑指 Offer 68 - II. 二叉树的最近公共祖先


题解：
1. 算法问题就是要把现实问题抽象为可判断真伪的对错问题
2. 递归问题不要画图而要套公式

最近公共祖先-->当 p、q 节点位于 root 节点的 两侧时，我们称 root 是 p q 的公共祖先

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
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        return root;
        // drill down
        // restore current status
    }
}
```