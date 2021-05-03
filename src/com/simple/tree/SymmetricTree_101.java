package com.simple.tree;

import com.TreeNode;

/**
 * @program:leetcode
 * @author:ibaip
 * @create:2021/5/3 15:42
 * <p>
 * 101. 对称二叉树
 **/
public class SymmetricTree_101 {
    // 递归实现
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        return dfs(root.left, root.right);
    }


    private boolean dfs(TreeNode left, TreeNode right) {
        // 递归结束条件：
        // 两个节点都为空，返回true；
        // 其中一个节点为空，返回false；
        // 两个节点的值不相等，返回false。

        if (left == null && right == null) {
            return true;
        }

        if (left == null || right == null) {
            return false;
        }

        if (left.val != right.val) {
            return false;
        }

        // 递归的比较left.left 和 right.right，递归比较 left.right 和 right.left。
        return dfs(left.left, right.right) && dfs(left.right, right.left);
    }
}
