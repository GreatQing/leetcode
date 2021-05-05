package com.medium.tree;

import com.TreeNode;

/**
 * @program:leetcode
 * @author:ibaip
 * @create:2021/5/5 9:26
 * <p>
 * 98. 验证二叉搜索树
 **/
public class ValidateBinarySearchTree_98 {

    // 二叉查找树（BST）也称为二叉搜索树或二叉排序树。二叉查找树的节点包含键值key。二叉查找树或者是一棵空树，否则要求：
    // 1. 若它的左子树不为空，那么左子树上所有节点的key都小于根节点的key。
    // 2. 若它的右子树不为空，那么右子树上所有节点的key都大于根节点的key。
    // 3. 它的左右子树也分别为二叉排序树。

    // 二叉搜索树「中序遍历」得到的值构成的序列一定是升序的，如果不满足升序，则不是二叉搜索树。
    // 可在中序遍历的时候实时检查当前节点的值是否大于前一个中序遍历到的节点的值。

    // 注意要设置long类型的最小值，而不是int类型的最小值。否则根节点为int类型的最小值时无法比较。
    private static long pre = Long.MIN_VALUE;

    public static boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (!isValidBST(root.left)) {
            return false;
        }

        int cur = root.val;
        if (cur > pre) {
            pre = cur;
        } else {
            return false;
        }

        return isValidBST(root.right);
    }

    public static void main(String[] args) {
        TreeNode node6 = new TreeNode(6);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4, node3, node6);
        TreeNode node1 = new TreeNode(1);
        TreeNode node5 = new TreeNode(5, node1, node4);

        System.out.println(isValidBST(node5));
    }
}
