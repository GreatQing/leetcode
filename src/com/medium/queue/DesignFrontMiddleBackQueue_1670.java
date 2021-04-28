package com.medium.queue;

/**
 * @program:leetcode
 * @author:ibaip
 * @create:2021/4/28 22:41
 * <p>
 * 1670. 设计前中后队列
 **/
public class DesignFrontMiddleBackQueue_1670 {

    // 通过双向链表实现
    private class Node {
        int val;
        Node prev;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    Node head;
    Node tail;
    int size;

    // 初始化队列。
    public DesignFrontMiddleBackQueue_1670() {
    }

    // 将 val 添加到队列的最前面 。
    public void pushFront(int val) {
        Node cur = new Node(val);
        if (isEmpty()) {
            head = cur;
            tail = cur;
        } else {
            cur.next = head;
            head.prev = cur;
            head = cur;
        }

        size++;
    }

    // 将 val 添加到队列的正中间。当有两个中间位置的时候，选择靠前面的位置进行操作。
    public void pushMiddle(int val) {
        Node cur = new Node(val);
        if (isEmpty()) {
            head = cur;
            tail = cur;
        } else if (size == 1) {
            cur.next = head;
            head.prev = cur;
            head = cur;
        } else {
            int mid = size / 2;
            Node midNode = head;
            for (int i = 1; i < mid; i++) {
                midNode = midNode.next;
            }

            midNode.next.prev = cur;
            cur.next = midNode.next;
            midNode.next = cur;
            cur.prev = midNode;
        }

        size++;
    }

    // 将 val 添加到队里的最后面 。
    public void pushBack(int val) {
        Node cur = new Node(val);
        if (isEmpty()) {
            head = cur;
            tail = cur;
        } else {
            tail.next = cur;
            cur.prev = tail;
            tail = cur;
        }

        size++;
    }

    // 将最前面的元素从队列中删除并返回值，如果删除之前队列为空，那么返回-1。
    public int popFront() {
        if (isEmpty()) {
            return -1;
        }

        int val = head.val;

        if (size == 1) {
            head = null;
            tail = null;
        } else {
            Node tmp = head.next;
            head.next = null;
            tmp.prev = null;
            head = tmp;
        }

        size--;
        return val;
    }

    // 将正中间的元素从队列中删除并返回值，如果删除之前队列为空，那么返回-1。
    public int popMiddle() {
        if (isEmpty()) {
            return -1;
        }

        int val = head.val;

        if (size == 1) {
            head = null;
            tail = null;
        } else if (size == 2) {
            Node tmp = head.next;
            head.next = null;
            tmp.prev = null;
            head = tmp;
        } else {
            int mid = (size - 1) / 2;
            Node midNode = head;
            for (int i = 0; i < mid; i++) {
                midNode = midNode.next;
            }
            val = midNode.val;

            midNode.prev.next = midNode.next;
            midNode.next.prev = midNode.prev;
            midNode.prev = null;
            midNode.next = null;
        }

        size--;
        return val;
    }

    //  将最后面的元素从队列中删除并返回值，如果删除之前队列为空，那么返回-1。
    public int popBack() {
        if (isEmpty()) {
            return -1;
        }

        int val = tail.val;

        if (size == 1) {
            head = null;
            tail = null;
        } else {
            Node tmp = tail.prev;
            tmp.next = null;
            tail.prev = null;
            tail = tmp;
        }

        size--;
        return val;
    }

    private boolean isEmpty() {
        return size == 0;
    }


    // 前两次要么执行出错，要么解答错误，都是不够全面细致画图，只是简单复制粘贴，导致midNode计算错误。
    // 第一次：直接在pushMiddle中调用pushFront，导致size错误；
    // 第二次：pushMiddle中循环次数计算错误，导致midNode错误；popMiddle中size计算错误，导致节点为偶数时midNode错误。

    public static void main(String[] args) {
        DesignFrontMiddleBackQueue_1670 q1 = new DesignFrontMiddleBackQueue_1670();
        q1.pushFront(1);   // [1]
        q1.pushBack(2);    // [1, 2]
        q1.pushMiddle(3);  // [1, 3, 2]
        q1.pushMiddle(4);  // [1, 4, 3, 2]
        System.out.println(q1.popFront());     // 返回 1 -> [4, 3, 2]
        System.out.println(q1.popMiddle());    // 返回 3 -> [4, 2]
        System.out.println(q1.popMiddle());    // 返回 4 -> [2]
        System.out.println(q1.popBack());      // 返回 2 -> []
        System.out.println(q1.popFront());     // 返回 -1 -> [] （队列为空）

        DesignFrontMiddleBackQueue_1670 q2 = new DesignFrontMiddleBackQueue_1670();
        q2.pushMiddle(1);  // [1]
        q2.pushMiddle(2);  // [2, 1]
        q2.pushMiddle(3);  // [2, 3, 1]
        System.out.println(q2.popMiddle());    // 返回 3 -> [2, 1]
        System.out.println(q2.popMiddle());    // 返回 2 -> [1]
        System.out.println(q2.popMiddle());    // 返回 1 -> [] （队列为空）

        DesignFrontMiddleBackQueue_1670 q3 = new DesignFrontMiddleBackQueue_1670();
        System.out.println(q3.popMiddle());     // 返回 -1 -> [] （队列为空）
        q3.pushMiddle(3);                   // [3]
        q3.pushFront(6);                    // [6, 3]
        q3.pushMiddle(6);                   // [6, 6, 3]
        q3.pushMiddle(3);                   // [6, 3, 6, 3]
        System.out.println(q3.popMiddle());     // 返回 3 -> [6, 6, 3]
        q3.pushMiddle(7);                   // [6, 3, 7, 6, 3]
        System.out.println(q3.popMiddle());     // 返回 7 -> [6, 3, 6, 3]
        q3.pushMiddle(3);                   // [6, 3, 3, 6, 3]


    }
}
