package com.simple.queue;

import java.util.Stack;

/**
 * @program:leetcode
 * @author:ibaip
 * @create:2021/4/28 20:51
 * <p>
 * 232. 用栈实现队列
 **/
public class ImplementQueueUsingStacks_232 {

    /** 使用两个栈，一个作为插入栈，一个作为删除栈 */

    Stack<Integer> stackIn;
    Stack<Integer> stackOut;

    public ImplementQueueUsingStacks_232() {
        stackIn = new Stack();
        stackOut = new Stack();
    }

    /** 将元素 x 推到队列的末尾 */
    public void push(int x) {
        stackIn.push(x);
    }

    /** 从队列的开头移除并返回元素 */
    public int pop() {
        if (!stackOut.isEmpty()) {
            return stackOut.pop();
        } else {
            while (!stackIn.isEmpty()) {
                stackOut.push(stackIn.pop());
            }

            return stackOut.pop();
        }
    }

    /** 返回队列开头的元素 */
    public int peek() {
        if (!stackOut.isEmpty()) {
            return stackOut.peek();
        } else {
            while (!stackIn.isEmpty()) {
                stackOut.push(stackIn.pop());
            }

            return stackOut.peek();
        }
    }

    /** 如果队列为空，返回true；否则，返回false */
    public boolean empty() {
        if (stackIn.isEmpty() && stackOut.isEmpty()) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        ImplementQueueUsingStacks_232 queue = new ImplementQueueUsingStacks_232();

        queue.push(1);
        queue.push(2);
        System.out.println(queue.peek());
        System.out.println(queue.pop());
        System.out.println(queue.empty());
        queue.push(3);
        System.out.println(queue.pop());
        System.out.println(queue.empty());
        System.out.println(queue.pop());
        System.out.println(queue.empty());
    }
}
