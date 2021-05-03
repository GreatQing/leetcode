package com.medium.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @program:leetcode
 * @author:ibaip
 * @create:2021/5/3 8:39
 *
 * 94.二叉树的中序遍历
 **/
public class BinaryTreeInorderTraversal_94 {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // 递归实现
    List<Integer> list = new ArrayList<>();

    public List<Integer> inorderTraversal1(TreeNode root) {
        // 1.如果二叉树为空，则返回链表
        if (root == null) {
            return list;
        }

        // 2.中序遍历左子树
        inorderTraversal1(root.left);
        // 3.保存节点值至链表
        list.add(root.val);
        // 4.中序遍历右子树
        inorderTraversal1(root.right);

        // 返回链表
        return list;
    }

    // 迭代实现
    public List<Integer> inorderTraversa2(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        // 如果二叉树为空，则返回链表。
        if (root == null) {
            return list;
        }

        // 创建一个Stack，然后按左->中->右的顺序输出节点。
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        while (!stack.isEmpty() || cur != null) {
            // 尽可能的将这个节点的左子树压入Stack，此时栈顶的元素是最左侧的元素。
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            // 左子树全部入栈后，弹出栈顶元素并保存。
            TreeNode node = stack.pop();
            list.add(node.val);

            // 如果有右节点，也要对其进行中序遍历。
            if (node.right != null) {
                cur = node.right;
            }
        }

        // 返回链表
        return list;
    }
}



