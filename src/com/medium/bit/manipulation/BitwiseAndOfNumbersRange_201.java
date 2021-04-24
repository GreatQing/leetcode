package com.medium.bit.manipulation;

/**
 * @program:leetcode
 * @author:ibaip
 * @create:2021/4/19 20:31
 * <p>
 * 201. 数字范围按位与
 **/
public class BitwiseAndOfNumbersRange_201 {

    // 核心是找到公共最长前缀
    public static int rangeBitwiseAnd1(int left, int right) {
        int i = 0;
        // 右移i位，寻找两个数字的公共前缀
        while (left != right) {
            left = left >> 1;
            right = right >> 1;
            i++;
        }

        // 将公共前缀左移i位得到结果
        left = left << i;

        return left;
    }

    public static int rangeBitwiseAnd2(int left, int right) {
        while (right > left) {
            // 抹去最右边的1
            right = right & (right - 1);
        }

        return right;
    }

    public static void main(String[] args) {
        System.out.println(rangeBitwiseAnd1(5, 7));
        System.out.println(rangeBitwiseAnd1(0, 0));
        System.out.println(rangeBitwiseAnd1(1, 1));
        System.out.println(rangeBitwiseAnd1(1, 2147483647));

        System.out.println(rangeBitwiseAnd2(5, 7));
        System.out.println(rangeBitwiseAnd2(0, 0));
        System.out.println(rangeBitwiseAnd2(1, 1));
        System.out.println(rangeBitwiseAnd2(1, 2147483647));
    }
}
