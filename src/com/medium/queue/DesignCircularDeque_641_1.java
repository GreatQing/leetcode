package com.medium.queue;

/**
 * @program:leetcode
 * @author:ibaip
 * @create:2021/4/26 22:25
 * <p>
 * 641. 设计循环双端队列
 **/

// 数组实现
public class DesignCircularDeque_641_1 {

    // 队头指针
    int front;
    // 数据域
    int[] data;
    // 数据个数
    int count;

    /**
     * 构造函数,双端队列的大小为k。
     */
    public DesignCircularDeque_641_1(int k) {
        front = 0;
        data = new int[k];
        count = 0;
    }

    /**
     * 将一个元素添加到双端队列头部。如果操作成功返回true。
     */
    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }

        if (!isEmpty()) {
            front = (front - 1 + data.length) % data.length;
        }
        data[front] = value;
        count++;

        return true;
    }

    /**
     * 将一个元素添加到双端队列尾部。如果操作成功返回true。
     */
    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }

        data[(front + count) % data.length] = value;
        count++;

        return true;
    }

    /**
     * 从双端队列头部删除一个元素。如果操作成功返回true。
     */
    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }

        front = (front + 1) % data.length;
        count--;

        return true;
    }

    /**
     * 从双端队列尾部删除一个元素。如果操作成功返回true。
     */
    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }

        count--;

        return true;
    }

    /**
     * 从双端队列头部获得一个元素。如果双端队列为空，返回-1。
     */
    public int getFront() {
        return isEmpty() ? -1 : data[front];
    }

    /**
     * 获得双端队列的最后一个元素。如果双端队列为空，返回-1。
     */
    public int getRear() {
        return isEmpty() ? -1 : data[(front + count - 1) % data.length];
    }

    /**
     * 检查双端队列是否为空。
     */
    public boolean isEmpty() {
        return count == 0;

    }

    /**
     * 检查双端队列是否满了。
     */
    public boolean isFull() {
        return count == data.length;
    }

    public static void main(String[] args) {
        DesignCircularDeque_641_1 circularDeque = new DesignCircularDeque_641_1(3); // 设置容量大小为3
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
