package com.simple.tree;

import com.TreeNode;

/**
 * @program:leetcode
 * @author:ibaip
 * @create:2021/5/10 21:48
 * <p>
 * 108. 将有序数组转换为二叉搜索树
 **/
public class ConvertSortedArrayToBinarySearchTree_108 {

    // 二叉搜索树中序遍历的结果就是一个升序序列。本题相当于根据中序遍历的结果恢复一棵二叉搜索树。
    // 以序列中任一元素为根节点，由左边升序序列构建左子树，右边升序序列构建右子树，即可得到一棵二叉搜索树。
    // 本题要求构建高度平衡的二叉搜索树，以中间元素为根节点进行构建即可。
    public TreeNode sortedArrayToBST(int[] nums) {
        return dfs(nums, 0, nums.length - 1);
    }

    private TreeNode dfs(int[] nums, int l, int r) {
        if (l > r) {
            return null;
        }

        int mid = l + (r - l) / 2;
        TreeNode node = new TreeNode(nums[mid]);

        node.left = dfs(nums, l, mid - 1);
        node.right = dfs(nums, mid + 1, r);

        return node;
    }
}
