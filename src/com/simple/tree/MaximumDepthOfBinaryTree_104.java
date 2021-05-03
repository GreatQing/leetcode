package com.simple.tree;

import com.TreeNode;

/**
 * @program:leetcode
 * @author:ibaip
 * @create:2021/5/3 16:26
 *
 * 104. 二叉树的最大深度
 **/
public class MaximumDepthOfBinaryTree_104 {

    // 如果我们知道了左子树和右子树的最大深度l和r，那么该二叉树的最大深度即为max(l,r)+1。
    // 而左子树和右子树的最大深度又可以以同样的方式进行计算。

    public int maxDepth(TreeNode root) {
        int n = 0;

        if (root == null) {
            return n;
        }

        int i = maxDepth(root.left);
        int j = maxDepth(root.right);
        n = Math.max(i, j) + 1;

        return n;
    }
}
