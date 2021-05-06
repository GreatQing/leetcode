package com.simple.math;

/**
 * @program:leetcode
 * @author:ibaip
 * @create:2021/5/6 20:15
 * <p>
 * 70. 爬楼梯
 **/
public class ClimbingStairs_70 {
    public static int climbStairs(int n) {
        // 斐波那契数列
        int r = 1;
        int p = 0, q = 0;

        for (int i = 0; i < n; i++) {
            q = p;
            p = r;
            r = p + q;
        }

        return r;
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(1));
        System.out.println(climbStairs(2));
        System.out.println(climbStairs(3));
        System.out.println(climbStairs(4));
        System.out.println(climbStairs(5));
    }
}
