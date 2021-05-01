package com.medium.stcak;

import java.util.Stack;

/**
 * @program:leetcode
 * @author:ibaip
 * @create:2021/5/1 15:19
 * <p>
 * 面试题 03.05. 栈排序
 **/
public class SortOfStackslcci_03_05 {

    Stack<Integer> main;
    Stack<Integer> tmp;

    public SortOfStackslcci_03_05() {
        main = new Stack<>();
        tmp = new Stack<>();
    }

    public void push(int val) {
        if (isEmpty()) {
            main.push(val);
        } else {
            while (!isEmpty() && val > main.peek()) {
                tmp.push(main.pop());
            }

            main.push(val);

            while (!tmp.isEmpty()) {
                main.push(tmp.pop());
            }
        }
    }

    public void pop() {
        if (!isEmpty()) {
            main.pop();
        }
    }

    // 当栈为空时，peek 返回 -1。
    public int peek() {
        if (isEmpty()) {
            return -1;
        } else {
            return main.peek();
        }
    }

    public boolean isEmpty() {
        return main.isEmpty();
    }

    public static void main(String[] args) {
        SortOfStackslcci_03_05 stack1 = new SortOfStackslcci_03_05();

        stack1.push(1);
        stack1.push(2);
        stack1.push(5);
        stack1.push(3);
        stack1.push(4);
        System.out.println(stack1.peek());
        stack1.pop();
        System.out.println(stack1.peek());
        stack1.pop();
        System.out.println(stack1.peek());
        stack1.pop();
        System.out.println(stack1.peek());
        stack1.pop();
        System.out.println(stack1.peek());
        stack1.pop();

        SortOfStackslcci_03_05 stack2 = new SortOfStackslcci_03_05();
        stack2.pop();
        stack2.pop();
        stack2.push(1);
        System.out.println(stack2.isEmpty());
    }
}
