package com.qing.great.simple.string;

/**
 * @program:leetcode
 * @author:ibaip
 * @create:2021/4/17 13:48
 *
 * 28. 实现 strStr()
 **/
public class ImplementStrstr_28 {
    public static int strStr(String haystack, String needle) {
        int m = haystack.length();
        int n = needle.length();

        for (int i = 0; i < m - n + 1; i++) {
            if (haystack.substring(i, i + n).equals(needle))  {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(strStr("hello","ll"));
        System.out.println(strStr("aaaaa","ba"));
        System.out.println(strStr("",""));
    }
}
