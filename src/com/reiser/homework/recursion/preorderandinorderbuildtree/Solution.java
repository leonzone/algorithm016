package com.reiser.homework.recursion.preorderandinorderbuildtree;

import com.reiser.homework.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: reiserx
 * Date:2020/9/25
 * Des:前序遍历和中序遍历构造二叉树
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 */
public class Solution {
    Map<Integer, Integer> indexMap = new HashMap<>();

    public TreeNode getTree(int[] preorder, int[] inorder, int preOrderLeft, int preOrderRight, int inOrderLeft, int inOrderRight) {
        // terminator
        if (preOrderLeft > preOrderRight) {
            return null;
        }
        // process current logic
        // 前序遍历中的第一个节点就是根节点
        int preOrderRoot = preOrderLeft;
        // 在中序遍历中定位根节点
        int inOrderRoot = indexMap.get(preorder[preOrderRoot]);

        // 得到左子树中的节点数目
        int sizeLeftSubtree = inOrderRoot - inOrderLeft;
        TreeNode root = new TreeNode(preorder[preOrderRoot]);
        // drill down
        root.left = getTree(preorder, inorder, preOrderLeft + 1, preOrderLeft + sizeLeftSubtree, inOrderLeft, inOrderRoot - 1);
        root.right = getTree(preorder, inorder, preOrderLeft + sizeLeftSubtree + 1, preOrderRight, inOrderRoot + 1, inOrderRight);
        // restore current status
        return root;

    }


    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        return getTree(preorder,inorder, 0, n - 1, 0, n - 1);
    }
}
