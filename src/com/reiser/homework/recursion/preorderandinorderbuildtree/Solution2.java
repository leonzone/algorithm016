package com.reiser.homework.recursion.preorderandinorderbuildtree;

import com.reiser.homework.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: reiserx
 * Date:2020/9/25
 * Des: 递归方式的简写
 * 但是这种代码不容易理解
 */
public class Solution2 {
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
