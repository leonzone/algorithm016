https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/description/

N 叉树的前序遍历

```java
public class NPreorderTraversal {

    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        pre(root, list);
        return list;
    }

    private void pre(Node root, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        for (Node child : root.children) {
            pre(child, list);
        }

    }
}
```