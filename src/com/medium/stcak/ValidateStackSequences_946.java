package com.medium.stcak;

import java.util.Stack;

/**
 * @program:leetcode
 * @author:ibaip
 * @create:2021/5/1 14:52
 * <p>
 * 946. 验证栈序列
 **/
public class ValidateStackSequences_946 {

    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        // 首先得有个栈
        Stack<Integer> stack = new Stack<>();

        int i = 0;
        int j = pushed.length;

        // 所有元素都是按顺序push进去的
        for (int x : pushed) {
            // 把push序列里面的每个元素都push进栈
            stack.push(x);

            // 检查栈顶元素是否为下一个需要pop的值，如果是的话把它pop出来
            while (!stack.isEmpty() && stack.peek() == popped[i]) {
                stack.pop();
                i++;
            }
        }

        // 最后判断所有push进栈的元素是否都被pop出来
        return i == j;
    }


    public static void main(String[] args) {
        System.out.println(validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{4, 5, 3, 2, 1}));
        System.out.println(validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{4, 3, 5, 1, 2}));
    }
}
