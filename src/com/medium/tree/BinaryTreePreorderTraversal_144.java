package com.medium.tree;

import com.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @program:leetcode
 * @author:ibaip
 * @create:2021/5/3 9:37
 * <p>
 * 144.二叉树的前序遍历
 **/
public class BinaryTreePreorderTraversal_144 {

    // 递归实现
    // 按照访问根节点->左子树->右子树的方式遍历这棵树，而在访问左子树或者右子树时，我们按照同样的方式遍历，直到遍历完整棵树。
    List<Integer> list = new ArrayList<>();

    public List<Integer> preorderTraversal1(TreeNode root) {
        if (root == null) {
            return list;
        }

        list.add(root.val);
        preorderTraversal1(root.left);
        preorderTraversal1(root.right);

        return list;
    }

    // 迭代实现
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        if (root == null) {
            return list;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.add(node.val);

            if (node.right != null) {
                stack.push(node.right);
            }

            if (node.left != null) {
                stack.push(node.left);
            }
        }

        return list;
    }
}
