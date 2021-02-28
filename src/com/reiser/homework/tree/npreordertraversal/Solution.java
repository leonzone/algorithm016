package com.reiser.homework.tree.npreordertraversal;

import com.reiser.homework.tree.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: reiserx
 * Date:2020/9/20
 * Des:N 叉数前序遍历
 */
//N 叉数前序遍历
public class Solution {

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
