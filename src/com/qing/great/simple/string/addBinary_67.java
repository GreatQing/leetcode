package com.qing.great.simple.string;

/**
 * @program:leetcode
 * @author:ibaip
 * @create:2021/4/17 20:00
 * <p>
 * 67. 二进制求和
 **/
public class addBinary_67 {
    // 可参考第415题：字符串相加
    public static String addBinary(String a, String b) {
        int i = 0;
        int l = Math.max(a.length(), b.length());

        int cur = 0;
        StringBuilder builder = new StringBuilder();

        while (i < l) {
            int intA = i < a.length() ? a.charAt(a.length() - i - 1) - '0' : 0;
            int intB = i < b.length() ? b.charAt(b.length() - i - 1) - '0' : 0;

            builder.append((intA + intB + cur) % 2);
            cur = (intA + intB + cur) / 2;

            i++;
        }

        if (cur == 1) {
            builder.append(1);
        }

        builder.reverse();

        return builder.toString();
    }




    public static void main(String[] args) {
        System.out.println(addBinary("11", "1"));
        System.out.println(addBinary("1010", "1011"));
    }
}
