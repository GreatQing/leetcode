package com.qing.great.simple.string;

/**
 * @program:leetcode
 * @author:ibaip
 * @create:2021/4/13 23:04
 * <p>
 * 415. 字符串相加
 * <p>
 * 给定两个字符串形式的非负整数num1和num2，计算它们的和。
 * 提示：
 * num1 和num2 的长度都小于 5100
 * num1 和num2 都只包含数字 0-9
 * num1 和num2 都不包含任何前导零
 * 不能使用任何內建 BigInteger库，也不能直接将输入的字符串转换为整数形式
 **/
public class AddStrings_415 {
    public static String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();

        int i = num1 == null ? -1 : num1.length() - 1;
        int j = num2 == null ? -1 : num2.length() - 1;

        int p = 0;

        while (i >= 0 || j >= 0) {
            int n1 = i >= 0 ? num1.charAt(i) - '0' : 0;
            int n2 = j >= 0 ? num2.charAt(j) - '0' : 0;
            int temp = n1 + n2 + p;
            sb.append(temp % 10);
            p = temp / 10;

            i--;
            j--;
        }

        if (p > 0) {
            sb.append(p);
        }

        if (sb.length() > 1) {
            reverse(sb);
        }

        return sb.toString();
    }

    private static void reverse(StringBuilder sb) {
        int i = 0;
        int j = sb.length() - 1;

        while (i < j) {
            char ch = sb.charAt(i);
            sb.setCharAt(i, sb.charAt(j));
            sb.setCharAt(j, ch);
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        // char其实也是一个数字，且0-9连续排列，可用如下小技巧进行char和int转换。
        // 同样的，如果我们想用1-26来表示字母’a’ 到 ‘z’ ，也可以用类似的方法来表示。

        // '1' -> 1
        char ch1 = '1';
        int int1 = ch1 - '0';

        // 2 -> '2'
        int int2 = 2;
        char ch2 = (char) (int2 + '0');

        System.out.println(addStrings("62345263", "95670347"));
    }
}
