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

    Stack<Integer> main = new Stack<>();
    Stack<Integer> tmp = new Stack<>();

    public SortOfStackslcci_03_05() {

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
        main.pop();
    }

    public int peek() {
        return main.peek();
    }

    public boolean isEmpty() {
        return main.isEmpty();
    }

    public static void main(String[] args) {
        SortOfStackslcci_03_05 stack = new SortOfStackslcci_03_05();

        stack.push(1);
        stack.push(2);
        stack.push(5);
        stack.push(3);
        stack.push(4);
        System.out.println(stack.peek());
        stack.pop();
        System.out.println(stack.peek());
        stack.pop();
        System.out.println(stack.peek());
        stack.pop();
        System.out.println(stack.peek());
        stack.pop();
        System.out.println(stack.peek());
        stack.pop();
    }
}
