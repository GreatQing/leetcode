package com.medium.stcak;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @program:leetcode
 * @author:ibaip
 * @create:2021/4/29 20:52
 * <p>
 * 394. 字符串解码
 **/
public class DecodeString_394 {

/**
 *遍历这个字符串：
 *如果当前的字符为数位，解析出一个数字（需考虑连续的多个数位的情况）并进栈
 *如果当前的字符为字母或者左括号，直接进栈
 *如果当前的字符为右括号，开始出栈，一直到左括号出栈，出栈序列反转后拼接成一个字符串。此时取出栈顶的数字，就是这个字符串应该出现的次数，根据这个次数和字符串构造出新的字符串并进栈。
 */

    int ptr;

    public String decodeString(String s) {
        ptr = 0;
        LinkedList<String> stk = new LinkedList<>();

        while (ptr < s.length()) {
            char cur = s.charAt(ptr);

            // 获取第一个数字字符，并把整个数字入栈
            if (Character.isDigit(cur)) {
                String digits = getDigits(s);
                stk.addLast(digits);

                // 获取一个字母并进栈
            } else if (Character.isLetter(cur) || cur == '[') {
                stk.addLast(String.valueOf(cur));
                ptr++;
            } else {
                ptr++;

                LinkedList<String> sub = new LinkedList<>();
                while (!"[".equals(stk.peekLast())) {
                    sub.addLast(stk.removeLast());
                }

                Collections.reverse(sub);

                // 左括号出栈
                stk.removeLast();

                // 此时栈顶为当前sub对应字符串应该出现的次数
                int repTime = Integer.parseInt(stk.removeLast());

                // 得到当前sub对应的字符串
                String string = getString(sub);

                StringBuilder sb = new StringBuilder();
                while (repTime > 0) {
                    sb.append(string);
                    repTime--;
                }

                // 将构造好的字符串入栈
                stk.addLast(sb.toString());
            }

        }

        // 返回栈内字符串即为解码后内容
        return getString(stk);
    }

    private String getDigits(String s) {
        StringBuilder sb = new StringBuilder();
        while (Character.isDigit(s.charAt(ptr))) {
            sb.append(s.charAt(ptr++));
        }

        return sb.toString();
    }

    private String getString(List<String> list) {
        StringBuilder sb = new StringBuilder();

        for (String s : list) {
            sb.append(s);
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        DecodeString_394 decode = new DecodeString_394();
        System.out.println(decode.decodeString("3[a]2[bc]"));
        System.out.println(decode.decodeString("3[a2[c]]"));
        System.out.println(decode.decodeString("2[abc]3[cd]ef"));
        System.out.println(decode.decodeString("abc3[cd]xyz"));
    }
}
