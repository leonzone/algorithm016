https://leetcode-cn.com/problems/binary-tree-inorder-traversal/

二叉树的中序遍历

```java
class Solution {
    List<Integer> list = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
       if(root==null) return list;
       inorderTraversal(root.left);
       list.add(root.val);
       inorderTraversal(root.right);
        return list;
    }
}
```