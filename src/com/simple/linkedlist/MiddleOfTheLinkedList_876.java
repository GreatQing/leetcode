package com.simple.linkedlist;

import com.ListNode;

/**
 * @program:leetcode
 * @author:ibaip
 * @create:2021/5/11 20:41
 *
 * 876. 链表的中间结点
 **/
public class MiddleOfTheLinkedList_876 {
    public ListNode middleNode(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode slow = head, fast = head;

        // 快慢指针找到中间结点
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
