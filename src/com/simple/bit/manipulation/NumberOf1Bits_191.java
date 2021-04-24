package com.simple.bit.manipulation;

/**
 * @program:leetcode
 * @author:ibaip
 * @create:2021/4/24 16:08
 * <p>
 * 191. 位1的个数
 **/
public class NumberOf1Bits_191 {
    // n & (n-1)操作可以把n的二进制位中最低位的1置为0。
    // 不断地对n进行n & (n-1)操作，直到n等于0。
    // 由于每次运算会使得n的最低位的1置为0，因此统计运算次数，即为n的二进制位中1的个数。
    public static int hammingWeight1(int n) {
        int i = 0;

        while (n != 0) {
            n = n & (n - 1);
            i++;
        }
        return i;
    }

    // 通过不断移位，判断n的二进制位中最低位是否为1，并进行统计
    public static int hammingWeight2(int n) {
        int i = 0;
        while (n != 0) {
            // 使用n & 1判断二进制末尾是否为1
            int m = n & 1;
            if (m == 1) {
                i++;
            }

            // 注意：对于负数而言，其二进制位最高位为1。
            // 如果使用带符号右移运算符（>>），高位填补的仍然是1。也就是说n右移后永远不会为0，最终程序将运行超时。
            // 如果使用无符号右移运算符（>>>），舍弃最低位，高位用0填补，则不会出现这个问题。
            n = n >>> 1;
        }

        return i;
    }

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(5) + "包含" + hammingWeight1(5) + "个1");
        System.out.println(Integer.toBinaryString(-5) + "包含" + hammingWeight1(-5) + "个1");
        System.out.println(Integer.toBinaryString(5) + "包含" + hammingWeight2(5) + "个1");
        System.out.println(Integer.toBinaryString(-5) + "包含" + hammingWeight2(-5) + "个1");
    }
}
