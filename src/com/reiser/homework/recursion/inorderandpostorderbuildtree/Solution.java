package com.reiser.homework.recursion.inorderandpostorderbuildtree;

import com.reiser.homework.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: reiserx
 * Date:2020/9/25
 * Des:后序遍历和中序遍历构造二叉树
 * https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};
        solution.buildTree(inorder, postorder);
    }

    Map<Integer, Integer> indexMap = new HashMap<>();

    private TreeNode getTree(int[] postorder, int[] inorder, int postorderLeft, int postorderRight, int inorderLeft, int inorderRight) {
        // terminator
        if (postorderLeft > postorderRight) {
            return null;
        }
        // process current logic
        int postorderRoot = postorderRight;
        int inorderRoot = indexMap.get(postorder[postorderRoot]);

        // 得到左子树中的节点数目
        int sizeLeftSubtree = inorderRoot - inorderLeft;
        TreeNode root = new TreeNode(postorder[postorderRoot]);

        // drill down
        root.left = getTree(postorder, inorder, postorderLeft, postorderLeft + sizeLeftSubtree-1, inorderLeft, inorderRoot - 1);
        root.right = getTree(postorder, inorder, postorderLeft + sizeLeftSubtree, postorderRight - 1, inorderRoot + 1, inorderRight);
        // restore current status
        return root;

    }

//    public TreeNode buildTree(int is, int ie, int ps, int pe) {
//        if(ie < is || pe < ps) return null;
//
//        int root = post[pe];
//        int ri = memo.get(root);
//
//        TreeNode node = new TreeNode(root);
//        node.left = buildTree(is, ri - 1, ps, ps + ri - is - 1);
//        node.right = buildTree(ri + 1, ie, ps + ri - is, pe - 1);
//        return node;
//    }


    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = postorder.length;
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        return getTree(postorder, inorder, 0, n-1, 0, n-1);
    }


}
