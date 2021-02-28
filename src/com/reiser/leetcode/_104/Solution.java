package com.reiser.leetcode._104;

import com.reiser.homework.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: reiserx
 * Date:2021/1/11
 * Des:
 */
public class Solution {

//    public int maxDepth(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
//    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int ans = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
                size--;
            }
            ans++;
        }
        return ans;
    }
}
