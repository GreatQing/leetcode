package com.simple.string;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @program:leetcode
 * @author:ibaip
 * @create:2021/5/2 8:34
 * <p>
 * 20. 有效的括号
 **/
public class ValidParentheses_20 {
    public static boolean isValid(String s) {
        Stack stack = new Stack();

        // 使用哈希表存储每一种括号。哈希表的键为右括号，值为相同类型的左括号。
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        for (char c : s.toCharArray()) {
            // 当遇到一个左括号时，将这个左括号放入栈顶。
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }

            //  当遇到一个右括号时，取出栈顶的左括号并判断它们是否是相同类型的括号。如果是的话，弹出栈顶的左括号。
            if (c == ')' || c == '}' || c == ']') {
                if (!stack.isEmpty() && stack.peek() == map.get(c)) {
                    stack.pop();
                } else {
                    // 要考虑只有右括号的场景
                    return false;
                }
            }
        }

        // 遍历结束后，如果栈中没有左括号，说明已将字符串s中的所有左括号闭合，返回True，否则返回False。
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s1 = "()";
        String s2 = "()[]{}";
        String s3 = "(]";
        String s4 = "([)]";
        String s5 = "{[]}";
        String s6 = "]}";

        System.out.println(isValid(s1));
        System.out.println(isValid(s2));
        System.out.println(isValid(s3));
        System.out.println(isValid(s4));
        System.out.println(isValid(s5));
        System.out.println(isValid(s6));
    }
}
