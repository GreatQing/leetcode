package com.simple.string;

/**
 * @program:leetcode
 * @author:ibaip
 * @create:2021/5/10 21:00
 * <p>
 * 38. 外观数列
 **/
public class CountAndSay_38 {
    public static String countAndSay(int n) {
        String s = "1";
        for (int i = 1; i < n; i++) {
            s = describe(s);
        }

        return s;
    }

    private static String describe(String s) {
        StringBuilder res = new StringBuilder();
        if (s.length() == 1) {
            res.append(1);
            res.append(s);
        }

        int num = 1;
        for (int i = 1; i < s.length(); i++) {
            // 比较字符串的当前位 i 与上一位 i - 1 是否相等
            if (s.charAt(i - 1) == s.charAt(i)) {
                // 相等：计数器num加1
                num++;
            } else {
                // 不相等，把上一段区间的num和字符加入res
                res.append(num);
                res.append(s.charAt(i - 1));

                // 重置计数器
                num = 1;
            }

            // 特殊情况：若已到达字符串最后一位，把最后一位字符加入res
            if (i == s.length() - 1) {
                res.append(num);
                res.append(s.charAt(i));
            }
        }

        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(countAndSay(1));
        System.out.println(countAndSay(2));
        System.out.println(countAndSay(3));
        System.out.println(countAndSay(4));
        System.out.println(countAndSay(5));
        System.out.println(countAndSay(6));
        System.out.println(countAndSay(7));
    }
}
