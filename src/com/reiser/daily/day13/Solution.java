package com.reiser.daily.day13;

import com.reiser.homework.tree.TreeNode;

/**
 * @author: reiserx
 * Date:2020/9/20
 * Des:
 */
public class Solution {
    public static void main(String[] args) {
        String key="geektime";
        int h=key.hashCode();
        System.out.println(h);
        System.out.println(h >>> 16);
        System.out.println((h = key.hashCode()) ^ (h >>> 16));
    }
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
