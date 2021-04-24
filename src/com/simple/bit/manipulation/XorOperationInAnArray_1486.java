package com.simple.bit.manipulation;

/**
 * @program:leetcode
 * @author:ibaip
 * @create:2021/4/18 20:38
 * <p>
 * 1486. 数组异或操作
 **/
public class XorOperationInAnArray_1486 {
    public static int xorOperation(int n, int start) {
        int res = 0;

        for (int i = 0; i < n; i++) {
            res = res ^ (start + 2 * i);
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(xorOperation(5, 0));
        System.out.println(xorOperation(4, 3));
        System.out.println(xorOperation(1, 7));
        System.out.println(xorOperation(10, 5));
    }
}
