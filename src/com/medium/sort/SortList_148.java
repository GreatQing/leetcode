package com.medium.sort;

import com.ListNode;

/**
 * @program:leetcode
 * @author:ibaip
 * @create:2021/5/14 21:40
 * <p>
 * 148. 排序链表
 **/
public class SortList_148 {
    public ListNode sortList(ListNode head) {
        // 1.分解：将待排序的n个元素分成两个子序列，每个子序列为n/2个元素
        // 2.治理：每个子序列分别调用归并排序，进行递归操作
        // 3.合并：将排序好的子序列合并
        if (head == null || head.next == null) {
            return head;
        }

        ListNode middle = getMiddle(head);
        ListNode half = middle.next;

        middle.next = null;

        return merge(sortList(head), sortList(half));
    }

    private ListNode getMiddle(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode slow = head, fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    private ListNode merge(ListNode a, ListNode b) {
        ListNode dummy = new ListNode(0);
        ListNode node = dummy;

        while (a != null && b != null) {
            if (a.val < b.val) {
                node.next = a;
                a = a.next;
            } else {
                node.next = b;
                b = b.next;
            }

            node = node.next;
        }

        node.next = (a == null) ? b : a;

        return dummy.next;
    }
}
