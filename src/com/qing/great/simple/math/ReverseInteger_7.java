package com.qing.great.simple.math;

/**
 * @program:leetcode
 * @author:ibaip
 * @create:2021/4/15 19:58
 *
 * 7. 整数反转
 *
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 *
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 **/

public class ReverseInteger_7 {
    /*
    思路
    从数字末尾开始，逐次把末尾的数字取出并拼接成反转后的结果。
    其中，取模可以得到末尾的数字，除以10可以去掉末尾的数字。
     */
    public static int reverse(int x) {

        int res = 0;
        while (x != 0) {
            // 取出末尾的数字
            int tmp = x % 10;

            // 防止正整数溢出
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && tmp > Integer.MAX_VALUE % 10)) {
                return 0;
            }

            // 防止负整数溢出
            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && tmp < Integer.MIN_VALUE % 10)) {
                return 0;
            }

            // 拼接反转后的结果
            res = res * 10 + tmp;
            // 去掉末尾的数字
            x /= 10;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(reverse(0));
        System.out.println(reverse(12345));
        System.out.println(reverse(-12345));
        System.out.println(reverse(2147483647));
        System.out.println(reverse(-2147483648));
    }
}
