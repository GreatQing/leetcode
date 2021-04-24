package com.simple.bit.manipulation;

/**
 * @program:leetcode
 * @author:ibaip
 * @create:2021/4/8 23:36
 * <p>
 * 136. 只出现一次的数字
 * <p>
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 **/
public class SingleNumber_136 {
    // 异或运算有以下三个性质：
    // 任何数和0做异或运算，结果是它本身，即a⊕0=a；
    // 任何数和其自身做异或运算，结果是0，即a⊕a=0；
    // 异或运算满足交换律和结合律，即a⊕b⊕a=b⊕a⊕a=b⊕(a⊕a)=b⊕0=b。

    public static int singleNumber(int[] nums) {
        int n = 0;

        for (int i : nums) {
            n ^= i;
        }

        return n;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 3, 2, 4, 4};

        System.out.println(singleNumber(nums));
    }
}
