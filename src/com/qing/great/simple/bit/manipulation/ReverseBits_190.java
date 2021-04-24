package com.qing.great.simple.bit.manipulation;

/**
 * @program:leetcode
 * @author:ibaip
 * @create:2021/4/24 16:59
 * <p>
 * 190. 颠倒二进制位
 **/
public class ReverseBits_190 {
    public static int reverseBits(int n) {
        int res = 0;

        for (int i = 0; i < 32; i++) {
            // 每次获取二进制位最后一位并拼接到颠倒后的二进制位末尾
            res = (res << 1) | (n & 1);
            n = n >>> 1;
        }

        return res;
    }

    public static void main(String[] args) {
        int a = 43261596;
        System.out.println(reverseBits(a)); // 964176192
    }
}
