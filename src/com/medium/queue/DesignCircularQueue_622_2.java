package com.medium.queue;

/**
 * @program:leetcode
 * @author:ibaip
 * @create:2021/4/26 21:09
 * <p>
 * 622. 设计循环队列
 **/

// 通过链表实现。
public class DesignCircularQueue_622_2 {
    // 链表节点
    private class Node {
        int vlaue;
        Node next;

        Node(int value) {
            this.vlaue = value;
        }
    }

    // 队头指针，队尾指针
    Node front, rear;
    // 链表大小，队列容量
    int count, size;

    public DesignCircularQueue_622_2(int k) {
        size = k;
    }

    // 向循环队列插入一个元素。如果成功插入则返回真。
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }

        Node node = new Node(value);

        if (isEmpty()) {
            front = node;
            rear = node;
        } else {
            rear.next = node;
            rear = node;
        }

        count++;

        return true;
    }

    // 从循环队列中删除一个元素。如果成功删除则返回真。
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }

        front = front.next;
        count--;
        return true;
    }

    // 从队首获取元素。如果队列为空，返回-1。
    public int Front() {
        return isEmpty() ? -1 : front.vlaue;
    }

    // 获取队尾元素。如果队列为空，返回-1。
    public int Rear() {
        return isEmpty() ? -1 : rear.vlaue;
    }

    // 检查循环队列是否为空。
    public boolean isEmpty() {
        return count == 0;
    }

    // 检查循环队列是否已满。
    public boolean isFull() {
        return count == size;
    }

    public static void main(String[] args) {
        DesignCircularQueue_622_2 circularQueue = new DesignCircularQueue_622_2(6);

        System.out.println(circularQueue.enQueue(6));// 返回 true
        System.out.println(circularQueue.Front());// 返回 6
        System.out.println(circularQueue.Rear());// 返回 6
        System.out.println(circularQueue.deQueue());// 返回 true
        System.out.println(circularQueue.enQueue(5));// 返回 true
        System.out.println(circularQueue.Rear());// 返回 5
        System.out.println(circularQueue.deQueue());// 返回 true
        System.out.println(circularQueue.Front());// 返回 -1
        System.out.println(circularQueue.Rear());// 返回 -1
        System.out.println(circularQueue.deQueue());// 返回 false
    }
}

