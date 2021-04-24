package com.simple.bit.manipulation;

/**
 * @program:leetcode
 * @author:ibaip
 * @create:2021/4/24 15:01
 * <p>
 * 461. 汉明距离
 **/
public class HammingDistance_461 {
    // 两个整数之间的汉明距离是对应位置上数字不同的位数。
    // 计算x和y之间的汉明距离，可以先计算x XOR y，然后统计结果中等于1的位数。

    public static int hammingDistance1(int x, int y) {
        // Integer.bitCount(int i)返回指定int值的二进制补码表示形式的1位的数量。
        return Integer.bitCount(x ^ y);
    }

    public static int hammingDistance2(int x, int y) {
        int a = x ^ y;

        // 为了计算等于1的位数，可以将每个位移动到最左侧或最右侧，然后检查该位是否为1。
        int i = 0;
        while (a != 0) {
            // 检查最右位是否为1，可以使用AND操作（i & 1），这个操作会屏蔽最右位以外的其他位。
            int b = a & 1;
            if (b == 1) {
                i++;
            }

            a = a >> 1;
        }

        return i;
    }

    public static void main(String[] args) {
        System.out.println(hammingDistance1(1, 4));
        System.out.println(hammingDistance2(1, 4));
    }
}
