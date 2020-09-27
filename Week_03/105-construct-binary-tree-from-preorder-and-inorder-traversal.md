https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/

105. 从前序与中序遍历序列构造二叉树


## 解题1
1. 前序遍历: 根节点在的第一位
2. 中序遍历: 根节点左侧是左子树，右侧是右子树

对于
前序遍历 preorder = [3,9,20,15,7]
中序遍历 inorder = [9,3,15,20,7]

preorder 中,得知 [3] 是根节点,所以 inorder 中，[3] 的左侧 [9] 是左子树;右侧[15,20,7] 是右子树。
递归找后面的根节点s
 
```java
//TODO 简化变量
class Solution {
   Map<Integer, Integer> indexMap = new HashMap<>();

    public TreeNode getTree(int[] preorder, int preOrderLeft, int preOrderRight, int inOrderLeft) {
        // terminator
        if (preOrderLeft > preOrderRight) {
            return null;
        }
        // process current logic
        // 前序遍历中的第一个节点就是根节点
        // 在中序遍历中定位根节点
        int inOrderRoot = indexMap.get(preorder[preOrderLeft]);

        // 得到左子树中的节点数目
        int sizeLeftSubtree = inOrderRoot - inOrderLeft;
        TreeNode root = new TreeNode(preorder[preOrderLeft]);
        // drill down
        root.left = getTree(preorder, preOrderLeft + 1, preOrderLeft + sizeLeftSubtree, inOrderLeft);
        root.right = getTree(preorder, preOrderLeft + sizeLeftSubtree + 1, preOrderRight, inOrderRoot + 1);
        // restore current status
        return root;

    }


    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        return getTree(preorder, 0, n - 1, 0);
    }
}
```

国际站上看到一个[不需要 map 的方案](https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/discuss/34543/Simple-O(n)-without-map)

```java
class Solution {
    private int in = 0;
    private int pre = 0;
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, Integer.MIN_VALUE);
    }
    
    private TreeNode build(int[] preorder, int[] inorder, int stop) {
        if (pre >= preorder.length) return null;
        if (inorder[in] == stop) {
            in++;
            return null;
        }
        TreeNode node = new TreeNode(preorder[pre++]);
        node.left = build(preorder, inorder, node.val);
        node.right = build(preorder, inorder, stop);
        return node;        
    }
}
```