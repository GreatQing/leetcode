package com.simple.queue;

import java.util.Stack;

/**
 * @program:leetcode
 * @author:ibaip
 * @create:2021/4/27 21:14
 *
 * 剑指 Offer 09. 用两个栈实现队列
 **/
public class YongLiangGeZhanShiXianDuiLieLcof {
    // 维护两个栈，第一个栈支持插入操作，第二个栈支持删除操作。
    Stack<Integer> stackIn;
    Stack<Integer> stackOut;

    public YongLiangGeZhanShiXianDuiLieLcof() {
        this.stackIn = new Stack<>();
        this.stackOut = new Stack<>();
    }

    /**
     * 在队列尾部插入整数
     */
    public void appendTail(int value) {
        stackIn.push(value);
    }

    /**
     * 在队列头部删除整数，若队列中没有元素，deleteHead 操作返回 -1
     */
    public int deleteHead() {
        if (stackIn.isEmpty() && stackOut.isEmpty()) {
            return -1;
        }

        if (!stackOut.isEmpty()) {
            return stackOut.pop();
        }

        // 如果删除栈为空，则将插入栈里面的元素一个个弹出并插入到删除栈
        if (!stackIn.isEmpty() && stackOut.isEmpty()) {
            while (!stackIn.isEmpty()) {
                stackOut.push(stackIn.pop());
            }
        }

        return stackOut.pop();
    }

    public static void main(String[] args) {
        YongLiangGeZhanShiXianDuiLieLcof queue = new YongLiangGeZhanShiXianDuiLieLcof();
        queue.appendTail(1);
        queue.appendTail(2);
        System.out.println(queue.deleteHead());
        queue.appendTail(3);
        System.out.println(queue.deleteHead());
        System.out.println(queue.deleteHead());
        System.out.println(queue.deleteHead());
    }
}
