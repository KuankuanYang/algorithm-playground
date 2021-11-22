package io.kuankuan.leetcode.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Kuankuan Yang
 * @date 2021-11-19 15:12
 */
public class Node {
    public int val;
    public List<Node> children;

    public Node() {
        children = new ArrayList<>();
    }

    public Node(int _val) {
        val = _val;
        children = new ArrayList<>();
    }

    public Node(int _val, ArrayList<Node> _children) {
        val = _val;
        children = _children;
    }
}
