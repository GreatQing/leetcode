package com.simple.tree;

import com.TreeNode;

/**
 * @program:leetcode
 * @author:ibaip
 * @create:2021/5/4 9:21
 *
 * 543. 二叉树的直径
 **/
public class DiameterOfBinaryTree_543 {
    // 任意一条路径，可看作是由某个节点为起点，从其左儿子和右儿子向下遍历的路径拼接而成。
    // 那么其长度等于左子树深度加上右子树深度。
    // 我们考虑如何得到某个节点的深度，某个节点的深度为其左子树深度和右子树深度中较大的深度加1。

    int ans = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return ans;
    }

    private int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int l = depth(node.left);
        int r = depth(node.right);

        // 计算并更新最大路径长度
        ans = Math.max(ans, l + r);

        return Math.max(l, r) + 1;
    }
}
