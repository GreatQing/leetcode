package com.simple.array;

/**
 * @program:leetcode
 * @author:ibaip
 * @create:2021/5/6 21:18
 * <p>
 * 66. 加一
 **/
public class PlusOne_66 {
    // 原数组上修改
    public static int[] plusOne(int[] digits) {
        int len = digits.length;

        // 进位标志，初始化为是，即题中最后一位加一。
        boolean flag = true;

        int p;
        for (int i = len - 1; i >= 0; i--) {
            p = flag ? digits[i] + 1 : digits[i];
            digits[i] = p % 10;
            flag = p / 10 == 1;
        }

        if (flag == true) {
            digits = new int[len + 1];
            digits[0] = 1;
        }

        return digits;
    }

    public static void main(String[] args) {
        int[] d1 = {8, 9};
        int[] d2 = plusOne(d1);

        for (int i : d2) {
            System.out.print(i + " ");
        }


    }
}
