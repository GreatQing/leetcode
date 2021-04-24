package com.medium.bit.manipulation;

/**
 * @program:leetcode
 * @author:ibaip
 * @create:2021/4/24 21:06
 * <p>
 * 371. 两整数之和
 **/
public class SumOfTwoIntegers_371 {

    public static int getSum1(int a, int b) {
        // 循环条件：进位不为0
        while (b != 0) {
            // 1.不算进位
            int tmp = a ^ b;
            // 2.只算进位
            b = (a & b) << 1;
            // 重复上述1、2步
            a = tmp;
        }

        return a;
    }

    // 递归版本
    public static int getSum2(int a, int b) {
        return b == 0 ? a : getSum2(a ^ b, (a & b) << 1);
    }

    public static void main(String[] args) {
        System.out.println(getSum1(1, 1));
        System.out.println(getSum1(1, 0));
        System.out.println(getSum1(-1, -1));
        System.out.println(getSum1(1, -1));

        System.out.println(getSum2(1, 1));
        System.out.println(getSum2(1, 0));
        System.out.println(getSum2(-1, -1));
        System.out.println(getSum2(1, -1));
    }
}
