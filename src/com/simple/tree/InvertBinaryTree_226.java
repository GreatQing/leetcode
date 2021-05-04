package com.simple.tree;

import com.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @program:leetcode
 * @author:ibaip
 * @create:2021/5/4 9:41
 *
 * 226. 翻转二叉树
 **/
public class InvertBinaryTree_226 {

    // 层序遍历，逐个节点翻转其左右节点
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }

        // 借助队列对二叉树进行层序遍历
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            // 翻转其左右节点
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;

            // 如果左节点不为空，加入队列
            if (node.left != null) {
                queue.add(node.left);
            }

            // 如果右节点不为空，加入队列
            if (node.right != null) {
                queue.add(node.right);
            }
        }

        return root;
    }
}
