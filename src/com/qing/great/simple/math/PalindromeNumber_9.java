package com.qing.great.simple.math;

/**
 * @program:leetcode
 * @author:ibaip
 * @create:2021/4/15 20:07
 *
 * 9. 回文数
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 *
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。
 * 示例 1：
 *
 * 输入：x = 121
 * 输出：true
 * 示例 2：
 *
 * 输入：x = -121
 * 输出：false
 * 解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3：
 *
 * 输入：x = 10
 * 输出：false
 * 解释：从右向左读, 为 01 。因此它不是一个回文数。
 **/
public class PalindromeNumber_9 {
    /**
     * 思路
     * 如题可知，负数不是回文数；0是回文数，其余以0结尾的数字都不是。
     * 对于其他正整数，我们可以对其进行反转后比较是否相等来判断是否为回文数。
     * 有没有更好的方法呢？答案是反转一半的数字与另一个比较来判断。
     * 不但反转次数少一半，而且不用像第7题“整数反转”那样考虑整数溢出问题。
     * 问题的关键是怎么判断数字反转了一半：反转过程中，原数字逐渐变小，反转后的数字逐渐变大，当反转后的数字大于等于原数字时，即反转了一半。
     */
    public static boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        // 反转后的数字
        int y = 0;

        while (x > y) {
            int tmp = x % 10;
            y = y * 10 + tmp;
            x /= 10;
        }

        // 偶数位数字，当反转后的数字等于原数字时；奇数位数字，当反转后的数字除以10后等于原数字时，为回文数。
        if (x == y || x == y / 10) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(0));
        System.out.println(isPalindrome(1000));
        System.out.println(isPalindrome(12321));
        System.out.println(isPalindrome(123321));
        System.out.println(isPalindrome(-12321));
        System.out.println(isPalindrome(-123321));
    }
}
