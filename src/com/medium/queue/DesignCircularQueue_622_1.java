package com.medium.queue;

/**
 * @program:leetcode
 * @author:ibaip
 * @create:2021/4/26 19:44
 * <p>
 * 622. 设计循环队列
 **/

// 通过数组实现。
public class DesignCircularQueue_622_1 {
    // 对于一个固定大小的数组，任何位置都可以是队首。
    // 只要知道队列长度，就可以根据 (front + count - 1) % data.length 计算出队尾位置，因此不需要队尾属性。

    // 队头指针
    int front;
    // 数据域
    int[] data;
    // 数据个数
    int count;

    public DesignCircularQueue_622_1(int k) {
        front = 0;
        count = 0;
        data = new int[k];
    }

    // 向循环队列插入一个元素。如果成功插入则返回真。
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }

        // 队尾插入
        data[(front + count) % data.length] = value;
        count++;
        return true;
    }

    // 从循环队列中删除一个元素。如果成功删除则返回真。
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }

        front = (front + 1) % data.length;
        count--;
        return true;
    }

    // 从队首获取元素。如果队列为空，返回-1。
    public int Front() {
        if (isEmpty()) {
            return -1;
        }

        return data[front];
    }

    // 获取队尾元素。如果队列为空，返回-1。
    public int Rear() {
        if (isEmpty()) {
            return -1;
        }

        return data[(front + count - 1) % data.length];
    }

    // 检查循环队列是否为空。
    public boolean isEmpty() {
        return count == 0;

    }

    // 检查循环队列是否已满。
    public boolean isFull() {
        return count == data.length;
    }

    public static void main(String[] args) {
        DesignCircularQueue_622_1 circularQueue = new DesignCircularQueue_622_1(3);

        System.out.println(circularQueue.enQueue(1));// 返回 true
        System.out.println(circularQueue.enQueue(2)); // 返回 true
        System.out.println(circularQueue.enQueue(3)); // 返回 true
        System.out.println(circularQueue.enQueue(4)); // 返回 false，队列已满
        System.out.println(circularQueue.Rear()); // 返回 3
        System.out.println(circularQueue.isFull()); // 返回 true
        System.out.println(circularQueue.deQueue()); // 返回 true
        System.out.println(circularQueue.enQueue(4)); // 返回 true
        System.out.println(circularQueue.Rear()); // 返回 4
        System.out.println(circularQueue.deQueue()); // 返回 true
        System.out.println(circularQueue.deQueue()); // 返回 true
        System.out.println(circularQueue.deQueue()); // 返回 true
        System.out.println(circularQueue.deQueue()); // 返回 false，队列已空
        System.out.println(circularQueue.enQueue(1));// 返回 true
        System.out.println(circularQueue.Front()); // 返回 1
        System.out.println(circularQueue.Rear()); // 返回 1
    }
}
