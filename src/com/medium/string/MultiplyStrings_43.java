package com.medium.string;

/**
 * @program:leetcode
 * @author:ibaip
 * @create:2021/4/17 21:16
 * <p>
 * 43. 字符串相乘
 **/
public class MultiplyStrings_43 {
    public static String multiply1(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        String s = "0";

        for (int i = 0; i < num1.length(); i++) {
            int n1 = num1.charAt(num1.length() - i - 1) - '0';

            StringBuilder sb = new StringBuilder();
            int cur = 0;
            for (int j = num2.length() - 1; j >= 0; j--) {
                int n2 = num2.charAt(j) - '0';
                int tmp = n1 * n2 + cur;
                sb.append(tmp % 10);
                cur = tmp / 10;
            }

            if (cur > 0) {
                sb.append(cur);
            }

            sb.reverse();

            for (int j = 0; j < i; j++) {
                sb.append("0");
            }

            s = addStrings(s, new String(sb));
        }

        return s;
    }

    public static String multiply2(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        int[] res = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            int m = num1.charAt(i) - '0';
            for (int j = num2.length() - 1; j >= 0; j--) {
                int n = num2.charAt(j) - '0';

                int sum = res[i + j + 1] + m * n;
                res[i + j + 1] = sum % 10;
                res[i + j] = res[i + j] + sum / 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            if (i ==0 && res[i] == 0) {
                continue;
            }

            sb.append(res[i]);
        }

        return sb.toString();
    }

    public static String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();

        int i = 0;
        int l = Math.max(num1.length(), num2.length());

        int p = 0;

        while (i < l) {
            int n1 = i < num1.length() ? num1.charAt(num1.length() - i - 1) - '0' : 0;
            int n2 = i < num2.length() ? num2.charAt(num2.length() - i - 1) - '0' : 0;
            int temp = n1 + n2 + p;
            sb.append(temp % 10);
            p = temp / 10;

            i++;
        }

        if (p > 0) {
            sb.append(p);
        }

        sb.reverse();

        return sb.toString();
    }


    public static void main(String[] args) {
        System.out.println(multiply1("2", "3"));
        System.out.println(multiply1("34", "12"));
        System.out.println(multiply1("123", "456"));

        System.out.println(multiply2("2", "3"));
        System.out.println(multiply2("34", "12"));
        System.out.println(multiply2("123", "456"));
    }
}
