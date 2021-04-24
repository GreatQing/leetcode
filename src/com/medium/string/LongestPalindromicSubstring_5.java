package com.medium.string;

/**
 * @program:leetcode
 * @author:ibaip
 * @create:2021/4/17 14:54
 * <p>
 * 5. 最长回文子串
 **/
public class LongestPalindromicSubstring_5 {
    public static String longestPalindrome(String s) {
        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {
            // 回文串长度为奇数
            int l1 = expandAroundCenter(s, i, i);
            // 回文串长度为偶数
            int l2 = expandAroundCenter(s, i, i + 1);

            int len = Math.max(l1, l2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    // 中心拓展法
    private static int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        // 返回回文子串的长度
        return right - left - 1;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("cbbd"));
        System.out.println(longestPalindrome("a"));
        System.out.println(longestPalindrome("ac"));
        System.out.println(longestPalindrome("aabbaa"));
        System.out.println(longestPalindrome("cbbd"));
    }
}
