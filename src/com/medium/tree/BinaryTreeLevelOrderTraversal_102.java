package com.medium.tree;

import com.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @program:leetcode
 * @author:ibaip
 * @create:2021/5/3 15:09
 * <p>
 * 102. 二叉树的层序遍历
 **/
public class BinaryTreeLevelOrderTraversal_102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) {
            return lists;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            // 因为要求区分每一层，因此每一层遍历开始前，先记录队列中的节点数量n，也就是这一层的节点数。
            int n = queue.size();

            // 一次性处理完这一层的n个节点。
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            }

            lists.add(list);
        }

        return lists;
    }
}
