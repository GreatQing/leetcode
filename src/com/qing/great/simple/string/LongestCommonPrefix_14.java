package com.qing.great.simple.string;

/**
 * @program:leetcode
 * @author:ibaip
 * @create:2021/4/14 21:41
 **/
public class LongestCommonPrefix_14 {
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 0; j < strs.length; j++) {
                // 遇到最短的字符串或字符不相等的情况
                if (strs[j].length() == i || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }

        // 字符串数组中的每个字符串都相等，所有字符遍历了一遍
        return strs[0];
    }

    public static void main(String[] args) {
        String[] strs1 = {"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(strs1));

        String[] strs2 = {"aaa", "aaa", "aaa"};
        System.out.println(longestCommonPrefix(strs2));

        String[] strs3 = {"dog", "racecar", "car"};
        System.out.println(longestCommonPrefix(strs3));
    }
}
