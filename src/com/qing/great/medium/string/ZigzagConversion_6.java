package com.qing.great.medium.string;

import java.util.ArrayList;

/**
 * @program:leetcode
 * @author:ibaip
 * @create:2021/4/14 20:43
 * <p>
 * 6. Z字形变换
 * <p>
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串。
 **/
public class ZigzagConversion_6 {

    /*
    思路：
    字符所在行是从l1、l2...到ln，然后ln、ln-1...到l1，循环往复。即行索引的方向在0和n-1处会反转。
    可以用一个标识表示索引的变化方向，并在遍历字符串时按照这个规律逐个保存字符，最后逐行拼接并输出字符。
     */
    public static String convert(String s, int numRows) {
        if (s.length() < 2 || numRows == 1) {
            return s;
        }


        // 初始化一个数组链表，用于保存Z形转换后的字符
        ArrayList<StringBuilder> list = new ArrayList();
        for (int i = 0; i < numRows; i++) {
            list.add(new StringBuilder());
        }


        // 索引变化的方向
        int flag = -1;
        // 当前字符的行索引
        int i = 0;

        // 遍历字符串
        for (char c : s.toCharArray()) {
            // 行索引的方向在0和n-1处反转
            if (i == 0 || i == numRows - 1) {
                flag = -flag;
            }

            // 保存当前字符
            list.get(i).append(c);

            // 行索引向上或向下移动
            i = i + flag;
        }

        StringBuilder res = new StringBuilder();
        for (StringBuilder sb : list) {
            res.append(sb);
        }

        return res.toString();
    }

    public static void main(String[] args) {
        String s1 = "abcdefghijk";
        String s2 = "ab";

        System.out.println(convert(s1, 3));
        System.out.println(convert(s1, 4));
        System.out.println(convert(s2, 1));
    }
}
