package com.medium.sort;

import com.ListNode;

/**
 * @program:leetcode
 * @author:ibaip
 * @create:2021/5/13 22:34
 *
 * 147. 对链表进行插入排序
 **/
public class InsertionSortList_147 {

    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        ListNode cur = head;

        while (cur != null) {
            ListNode pre = dummy;
            ListNode next = cur.next;

            while (pre.next != null && pre.next.val < cur.val) {
                pre = pre.next;
            }

            cur.next = pre.next;
            pre.next = cur;
            cur = next;
        }

        return dummy.next;
    }
}
