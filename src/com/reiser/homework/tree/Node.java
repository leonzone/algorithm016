package com.reiser.homework.tree;

import java.util.List;

/**
 * @author: reiserx
 * Date:2020/9/20
 * Des:
 */
public class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
