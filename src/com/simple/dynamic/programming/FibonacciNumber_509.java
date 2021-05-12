package com.simple.dynamic.programming;

/**
 * @program:leetcode
 * @author:ibaip
 * @create:2021/5/12 21:10
 * <p>
 * 509. 斐波那契数
 **/
public class FibonacciNumber_509 {
    public static int fib(int n) {
        int a = 0, b = 1;
        int sum;

        for (int i = 0; i < n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }

        return a;
    }

    public static void main(String[] args) {
        System.out.println(fib(0));
        System.out.println(fib(1));
        System.out.println(fib(2));
        System.out.println(fib(3));
        System.out.println(fib(4));
        System.out.println(fib(5));
        System.out.println(fib(6));
        System.out.println(fib(7));
        System.out.println(fib(8));
    }
}
