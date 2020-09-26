package com.reiser.homework.recursion.mergetwobinarytrees;

import com.reiser.homework.tree.TreeNode;

/**
 * @author: reiserx
 * Date:2020/9/23
 * Des:
 */
public class Solution {

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        // terminator
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        // process current logic
        TreeNode merge = new TreeNode(t1.val + t1.val);
        // drill down
        merge.left = mergeTrees(t1.left, t2.left);
        merge.right = mergeTrees(t1.right, t2.right);
        // restore current status
        return merge;
    }


}
