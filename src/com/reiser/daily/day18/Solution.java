package com.reiser.daily.day18;

import com.reiser.homework.tree.TreeNode;

/**
 * @author: reiserx
 * Date:2020/9/25
 * Des:
 */
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
