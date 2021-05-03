package com.medium.tree;

import com.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @program:leetcode
 * @author:ibaip
 * @create:2021/5/3 11:34
 * <p>
 * 145.二叉树的后序遍历
 **/
public class BinaryTreePostorderTraversal_145 {
    // 递归实现
    List<Integer> list = new ArrayList<>();

    public List<Integer> postorderTraversal1(TreeNode root) {
        if (root == null) {
            return list;
        }

        postorderTraversal1(root.left);
        postorderTraversal1(root.right);
        list.add(root.val);

        return list;
    }

    // 迭代实现
    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        if (root == null) {
            return list;
        }

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        // 已知前序遍历的过程是中左右，后序遍历的过程是左右中
        // 首先将中左右转化成中右左，即先入栈左子树，再入栈右子树
        // 然后将结果倒序，得到左右中。可利用栈后进先出的特性进行倒序

        stack1.push(root);
        while (!stack1.isEmpty()) {
            TreeNode node = stack1.pop();
            stack2.push(node.val);

            if (node.left != null) {
                stack1.push(node.left);
            }

            if (node.right != null) {
                stack1.push(node.right);
            }
        }

        while (!stack2.isEmpty()) {
            list.add(stack2.pop());
        }

        return list;
    }
}
