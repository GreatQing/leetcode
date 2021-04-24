package com.qing.great.simple.string;

/**
 * @program:leetcode
 * @author:ibaip
 * @create:2021/4/13 19:33
 * <p>
 * 13. 罗马数字转整数
 * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
 * 例如， 罗马数字2写做 II ，即为两个并列的1。12写做XII ，即为X + II 。 27写做XXVII, 即为XX + V + II 。
 * <p>
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如4不写做IIII，而是IV。
 * 数字1在数字5的左边，所表示的数等于大数5减小数1得到的数值4。同样地，数字9表示为IX。这个特殊的规则只适用于以下六种情况：
 * <p>
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
 **/
public class RomanToInteger_13 {
    // 如果从右往左看罗马数字，通常情况下，当前的数字大于右边的数字，此时加上当前的数字；如果当前的数字小于右边的数字，则需减去当前的数字。
    public static int romanToInt(String s) {
        int sum = 0;

        if (s != null) {
            int preNum = 0;
            for (int i = s.length() - 1; i >= 0; i--) {
                int curNum = getNum(s.charAt(i));

                if (curNum < preNum) {
                    sum = sum - curNum;
                } else {
                    sum = sum + curNum;
                }

                preNum = curNum;
            }
        }

        return sum;
    }

    private static int getNum(char ch) {
        switch (ch) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }

    public static void main(String[] args) {
        String s1 = "XXVII";
        String s2 = "III";
        String s3 = "XXIV";
        String s4 = "MCDXII";

        System.out.println(romanToInt(s1));
        System.out.println(romanToInt(s2));
        System.out.println(romanToInt(s3));
        System.out.println(romanToInt(s4));
    }
}
