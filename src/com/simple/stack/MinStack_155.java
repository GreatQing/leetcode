package com.simple.stack;

/**
 * @program:leetcode
 * @author:ibaip
 * @create:2021/4/29 20:26
 * <p>
 * 155. 最小栈
 **/
public class MinStack_155 {

    // 通过链表实现。链表节点包含当前值，当前最小值，和前一个节点
    private class Node {
        int val;
        int min;
        Node prev;

        Node(int val, int min) {
            this.val = val;
            this.min = min;
        }
    }

    Node node;

    public MinStack_155() {

    }

    public void push(int val) {
        if (node == null) {
            node = new Node(val, val);
        } else {
            Node next = new Node(val, Math.min(val, getMin()));
            next.prev = node;
            node = next;
        }
    }

    public void pop() {
        node = node.prev;
    }

    public int top() {
        return node.val;
    }

    public int getMin() {
        return node.min;
    }


    public static void main(String[] args) {
        MinStack_155 minStack = new MinStack_155();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());   // 返回 -3.
        minStack.pop();
        System.out.println(minStack.top());      // 返回 0.
        System.out.println(minStack.getMin());  // 返回 -2.
    }
}
