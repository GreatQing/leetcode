package com.medium.tree;

import com.TreeNode;

/**
 * @program:leetcode
 * @author:ibaip
 * @create:2021/5/4 10:56
 * <p>
 * 105. 从前序与中序遍历序列构造二叉树
 **/
public class ConstructBinaryTreeFromPreorderAndInorderTraversal_105 {

    // 前序遍历的顺序是根节点，左子树，右子树。中序遍历的顺序是左子树，根节点，右子树。
    // 所以我们只需要根据前序遍历得到根节点，然后在中序遍历中找到根节点的位置，它的左边就是左子树的节点，右边就是右子树的节点。
    // 递归生成左子树和右子树。

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    public TreeNode helper(int[] preorder, int p_start, int p_end, int[] inorder, int i_start, int i_end) {
        // preorder 为空，直接返回null

        if (p_start == p_end) {
            return null;
        }

        int root_val = preorder[p_start];
        TreeNode root = new TreeNode(root_val);

        // 在中序遍历中找到根节点的位置
        int i_root_index = 0;
        for (int i = i_start; i < i_end; i++) {
            if (root_val == inorder[i]) {
                i_root_index = i;
                break;
            }
        }

        int left_num = i_root_index - i_start;

        // 递归构建左子树
        root.left = helper(preorder, p_start + 1, p_start + left_num + 1, inorder, i_start, i_start + left_num);
        // 递归构建右子树
        root.right = helper(preorder, p_start + left_num + 1, p_end, inorder, i_root_index + 1, i_end);

        return root;
    }
}
