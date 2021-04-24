package com.medium.string;

/**
 * @program:leetcode
 * @author:ibaip
 * @create:2021/4/22 21:01
 * <p>
 * 647. 回文子串
 **/
public class PalindromicSubstrings_647 {

    // 计算有多少个回文子串的最朴素方法就是枚举出所有的回文子串，而枚举出所有的回文字串又有两种思路，分别是：
    // 1.枚举出所有的子串，然后再判断这些子串是否是回文；
    // 2.枚举每一个可能的回文中心，然后用两个指针分别向左右两边拓展，当两个指针指向的元素相同的时候即为一个回文子串，并继续拓展，否则停止拓展。

    public static int countSubstrings(String s) {
        int sum = 0;
        // 回文串长度为奇数
        for (int i = 0; i < s.length(); i++) {
            sum += expandAroundCenter(s, i, i);
        }

        // 回文串长度为偶数
        for (int i = 0; i < s.length(); i++) {
            sum += expandAroundCenter(s, i, i + 1);
        }

        return sum;
    }

    // 中心拓展法
    public static int expandAroundCenter(String s, int left, int right) {
        int sum = 0;

        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
            sum += 1;
        }

        return sum;
    }

    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "aaa";

        System.out.println(countSubstrings(s1));
        System.out.println(countSubstrings(s2));
    }
}
