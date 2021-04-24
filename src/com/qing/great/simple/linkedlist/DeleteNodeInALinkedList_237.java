package com.qing.great.simple.linkedlist;

/**
 * @program:leetcode
 * @author:ibaip
 * @create:2021/4/1 23:54
 *
 * 237. 删除链表中的节点
 * 请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点。传入函数的唯一参数为要被删除的节点 。
 **/
public class DeleteNodeInALinkedList_237 {

    // 删除一个节点最常见的做法就是将其前一个节点的next指针指向其后一个节点。
    // 因为本题无法访问要删除节点的前一个节点，考虑将删除节点的后一个节点的值赋值给它，然后删除它后一个节点。
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
