package com.medium.tree;

import com.ListNode;
import com.TreeNode;

/**
 * @program:leetcode
 * @author:ibaip
 * @create:2021/5/11 19:47
 * <p>
 * 109. 有序链表转换二叉搜索树
 **/
public class ConvertSortedListToBinarySearchTree_109 {
    public TreeNode sortedListToBST(ListNode head) {
        return dfs(head);
    }

    private TreeNode dfs(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode pre = head, slow = head, fast = head;

        // 利用快慢指针找到中间节点
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        TreeNode root = new TreeNode(slow.val);

        // 如果中间节点slow左边还有节点，需要构建左子树
        if (pre.next != null) {
            // 切断pre和中间节点slow
            pre.next = null;
            root.left = dfs(head);
        }

        // 构建右子树
        root.right = dfs(slow.next);

        return root;
    }
}
