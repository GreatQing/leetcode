package com.simple.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program:leetcode
 * @author:ibaip
 * @create:2021/4/28 21:50
 * <p>
 * 225. 用队列实现栈
 **/
public class ImplementStackUsingQueues_225 {

    /**
     * 使用两个队列，一个作为主队列，一个作为辅助队列。
     * 入栈的时候，首先将元素插入辅助队列，然后如果主队列不为空则将主队列的元素插入辅助队列，最后将辅助队列变为主队列。
     */

    Queue<Integer> queue1;
    Queue<Integer> queue2;

    public ImplementStackUsingQueues_225() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    /**
     * 将元素 x 压入栈顶。
     */
    public void push(int x) {
        // 首先将元素插入辅助队列
        queue2.offer(x);

        // 然后如果主队列不为空则将主队列的元素插入辅助队列
        while (!queue1.isEmpty()) {
            queue2.offer(queue1.poll());
        }

        // 最后将辅助队列变为主队列
        Queue tmp = queue1;
        queue1 = queue2;
        queue2 = tmp;
    }

    /**
     * 移除并返回栈顶元素。
     */
    public int pop() {
        return queue1.poll();
    }

    /**
     * 返回栈顶元素。
     */
    public int top() {
        return queue1.peek();
    }

    /**
     * 如果栈是空的，返回true；否则，返回false。
     */
    public boolean empty() {
        return queue1.isEmpty();
    }

    public static void main(String[] args) {
        ImplementStackUsingQueues_225 stack = new ImplementStackUsingQueues_225();

        stack.push(1);
        stack.push(2);
        System.out.println(stack.top());
        System.out.println(stack.pop());
        System.out.println(stack.empty());
        stack.push(3);
        System.out.println(stack.pop());
        System.out.println(stack.empty());
        System.out.println(stack.pop());
        System.out.println(stack.empty());
    }
}
