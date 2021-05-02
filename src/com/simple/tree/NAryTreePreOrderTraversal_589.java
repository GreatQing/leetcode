package com.simple.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @program:leetcode
 * @author:ibaip
 * @create:2021/5/2 21:10
 * <p>
 * 589. N叉树的前序遍历
 **/
public class NAryTreePreOrderTraversal_589 {
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
    List<Integer> list = new ArrayList<>();

    public List<Integer> preorder1(Node root) {
        // 1.如果树为空，则返回
        if (root == null) {
            return list;
        }

        // 2.保存节点值
        list.add(root.val);

        // 3.前序遍历每个子树
        for (Node childer : root.children) {
            preorder1(childer);
        }

        return list;
    }

    // 2.迭代实现
    public List<Integer> preorder2(Node root) {
        List<Integer> list = new ArrayList<>();

        // 借助一个栈来实现
        Stack<Node> stack = new Stack<>();

        if (root == null) {
            return list;
        }
        // 将根节点入栈
        stack.push(root);

        // 如果栈不为空，则将栈顶元素出栈并保存到链表，然后从右到左将所有孩子入栈
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            list.add(node.val);

            int size = node.children.size();
            for (int i = size - 1; i >= 0; i--) {
                stack.push(node.children.get(i));
            }
        }

        return list;
    }
}
