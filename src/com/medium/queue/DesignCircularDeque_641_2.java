package com.medium.queue;

/**
 * @program:leetcode
 * @author:ibaip
 * @create:2021/4/27 20:27
 * <p>
 * 641. 设计循环双端队列
 **/

// 双链表实现
public class DesignCircularDeque_641_2 {

    // 链表节点，采用双向链表
    private class Node {
        int value;
        Node prev;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    Node head;
    Node tail;
    int capacity;
    int size;

    /**
     * 构造函数,双端队列的大小为k。
     */
    public DesignCircularDeque_641_2(int k) {
        this.capacity = k;
        this.size = 0;
    }

    /**
     * 将一个元素添加到双端队列头部。如果操作成功返回true。
     */
    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }

        Node cur = new Node(value);

        if (isEmpty()) {
            tail = cur;
            head = cur;
        } else {
            cur.next = head;
            head.prev = cur;
            head = cur;
        }
        size++;

        return true;
    }

    /**
     * 将一个元素添加到双端队列尾部。如果操作成功返回true。
     */
    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }

        Node cur = new Node(value);

        if (isEmpty()) {
            tail = cur;
            head = cur;
        } else {
            tail.next = cur;
            cur.prev = tail;
            tail = cur;
        }
        size++;

        return true;
    }

    /**
     * 从双端队列头部删除一个元素。如果操作成功返回true。
     */
    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }

        Node tmp = head.next;
        head.next = null;
        if (tmp != null) {
            tmp.prev = null;
        }
        head = tmp;

        size--;
        return true;
    }

    /**
     * 从双端队列尾部删除一个元素。如果操作成功返回true。
     */
    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }

        Node tmp = tail.prev;
        tail.prev = null;
        if (tmp != null) {
            tmp.next = null;
        }
        tail = tmp;

        size--;
        return true;
    }

    /**
     * 从双端队列头部获得一个元素。如果双端队列为空，返回-1。
     */
    public int getFront() {
        return isEmpty() ? -1 : head.value;
    }

    /**
     * 获得双端队列的最后一个元素。如果双端队列为空，返回-1。
     */
    public int getRear() {
        return isEmpty() ? -1 : tail.value;
    }

    /**
     * 检查双端队列是否为空。
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 检查双端队列是否满了。
     */
    public boolean isFull() {
        return size == capacity;
    }

    public static void main(String[] args) {
        DesignCircularDeque_641_2 circularDeque = new DesignCircularDeque_641_2(3); // 设置容量大小为3
        System.out.println(circularDeque.insertLast(1));    // 返回 true
        System.out.println(circularDeque.insertLast(2));    // 返回 true
        System.out.println(circularDeque.insertFront(3));   // 返回 true
        System.out.println(circularDeque.insertFront(4));   // 已经满了，返回 false
        System.out.println(circularDeque.getRear());             // 返回 2
        System.out.println(circularDeque.isFull());              // 返回 true
        System.out.println(circularDeque.deleteLast());          // 返回 true
        System.out.println(circularDeque.insertFront(4));   // 返回 true
        System.out.println(circularDeque.getFront());            // 返回 4
        System.out.println(circularDeque.getRear());             // 返回 1
        System.out.println(circularDeque.deleteFront());         // 返回 true
        System.out.println(circularDeque.insertLast(5));    // 返回 true
        System.out.println(circularDeque.getFront());            // 返回 3
        System.out.println(circularDeque.getRear());             // 返回 5
        System.out.println(circularDeque.deleteFront());         // 返回 true
        System.out.println(circularDeque.deleteFront());         // 返回 true
        System.out.println(circularDeque.deleteFront());         // 返回 true
        System.out.println(circularDeque.deleteFront());         // 返回 已经空了，返回 false
        System.out.println(circularDeque.deleteLast());          // 返回 已经空了，返回 false

    }
}
