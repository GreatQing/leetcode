package com.simple.string;

/**
 * @program:leetcode
 * @author:ibaip
 * @create:2021/4/24 13:13
 *
 * 796. 旋转字符串
 **/
public class RotateString_796 {

    public static boolean rotateString(String A, String B) {
        if (A.length() != B.length()) {
            return false;
        }

        if (A.length() == 0) {
            return true;
        }

        // 设置跳转标识
        search:
        for (int i = 0; i < A.length(); i++) {
            for (int j = 0; j < A.length(); j++) {
                if (A.charAt(j) != B.charAt((i + j) % B.length())) {
                    // 里层循环continue直接跳至外层循环，继续执行外层循环
                    // 即A旋转一定位数后不等于B，A旋转位数+1继续判断
                    continue search;
                }
            }

            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(rotateString("abcde", "cdeab"));
        System.out.println(rotateString("abcde", "abced"));
        System.out.println(rotateString("", ""));
    }
}
