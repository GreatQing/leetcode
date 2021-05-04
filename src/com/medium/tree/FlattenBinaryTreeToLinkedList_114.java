package com.medium.tree;

import com.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @program:leetcode
 * @author:ibaip
 * @create:2021/5/4 16:08
 * <p>
 * 114.二叉树展开为链表
 **/
public class FlattenBinaryTreeToLinkedList_114 {
    // 将二叉树展开为单链表之后，单链表中的节点顺序即为二叉树的前序遍历访问各节点的顺序。因此，可以对二叉树进行前序遍历，获得各节点被访问到的顺序。
    // 由于将二叉树展开为链表之后会破坏二叉树的结构，因此在前序遍历结束之后更新每个节点的左右子节点的信息，将二叉树展开为单链表。
    public void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        helper(root, list);

        for (int i = 1; i < list.size(); i++) {
            TreeNode pre = list.get(i - 1);
            TreeNode cur = list.get(i);

            pre.left = null;
            pre.right = cur;
        }

    }

    private void helper(TreeNode root, List<TreeNode> list) {
        if (root != null) {
            list.add(root);
            helper(root.left, list);
            helper(root.right, list);
        }
    }
}
