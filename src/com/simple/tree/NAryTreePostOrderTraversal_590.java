package com.simple.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @program:leetcode
 * @author:ibaip
 * @create:2021/5/2 21:29
 * <p>
 * 590. N叉树的后序遍历
 **/
public class NAryTreePostOrderTraversal_590 {
    private class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    // 递归实现
    public List<Integer> postorder1(Node root) {
        List<Integer> list = new ArrayList<>();

        // 1.如果树为空，则返回
        if (root == null) {
            return list;
        }

        helper(root, list);

        return list;
    }

    private void helper(Node root, List<Integer> list) {
        // 2.后序遍历所有子树
        for (Node childer : root.children) {
            helper(childer, list);
        }

        // 3.保存节点值
        list.add(root.val);
    }

    // 迭代实现
    public List<Integer> postorder2(Node root) {
        List<Integer> list = new LinkedList<>();
        LinkedList<Node> stack = new LinkedList<>();

        // 如果树为空，则返回
        if (root == null) {
            return list;
        }

        // 将根节点入栈
        stack.push(root);

        // 如果栈不为空，从左到右将节点入栈。将栈顶节点出栈，并保存节点值
        while (!stack.isEmpty()) {
            Node node = stack.pollLast();
            ((LinkedList<Integer>) list).addFirst(node.val);

            for (Node children : node.children) {
                stack.add(children);
            }
        }

        return list;
    }
}
