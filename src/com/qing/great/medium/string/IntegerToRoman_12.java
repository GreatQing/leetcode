package com.qing.great.medium.string;

/**
 * @program:leetcode
 * @author:ibaip
 * @create:2021/4/16 0:03
 * <p>
 * 12. 整数转罗马数字
 **/
public class IntegerToRoman_12 {
    /**
     * 规则：根据整数从左到右选择尽可能大的罗马符号。
     * 思路：1.建立符号与值对应的序列，序列按从大到小排序。符号对应的值加起来就是整数。
     * 2.对于给定整数，遍历符号序列，根据值寻找适合它的最大符号，找到后记录下符合。再用整数减去符号对应的值，得到余数。
     * 3.将步骤2中的余数作为新的整数，不断重复步骤2，直到余数为0.
     */

    public static String intToRoman(int num) {
        String[] symbol = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] value = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        StringBuilder sb = new StringBuilder();

        // 遍历符号序列
        for (int i = 0; i < symbol.length && num >= 0; i++) {
            // 根据值寻找适合它的最大符号
            while (num >= value[i]) {
                sb.append(symbol[i]);
                num -= value[i];
            }
        }

        return sb.toString();
    }


    public static void main(String[] args) {
        System.out.println(intToRoman(3));
        System.out.println(intToRoman(4));
        System.out.println(intToRoman(9));
        System.out.println(intToRoman(58));
        System.out.println(intToRoman(672));
        System.out.println(intToRoman(1994));
    }
}
