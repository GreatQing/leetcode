package com.qing.great.simple.string;

/**
 * @program:leetcode
 * @author:ibaip
 * @create:2021/4/13 20:13
 * <p>
 * 557. 反转字符串中的单词 III
 * <p>
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 **/
public class ReverseWordsInAStringIII_557 {

    public static String reverseWords(String s) {
        if (s == null) {
            return "";
        }

        // String不可变。将此字符串转换为一个新的字符数组。
        char[] chars = s.toCharArray();

        int i = 0;
        int j = i;
        int length = chars.length;

        while (j < length) {
            while (j < length && chars[j] != ' ') {
                j++;
            }

            reverse(chars, i, j - 1);

            while (j < length && chars[j] == ' ') {
                j++;
            }

            i = j;
        }

        return new String(chars);
    }


    // 反转字符数组指定区间内的字符。
    private static void reverse(char[] chars, int i, int j) {
        while (i < j) {
            char ch = chars[i];
            chars[i] = chars[j];
            chars[j] = ch;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        System.out.println(reverseWords(s));
    }
}
