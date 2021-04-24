package com.simple.string;

/**
 * @program:leetcode
 * @author:ibaip
 * @create:2021/4/18 9:56
 * <p>
 * 125. 验证回文串
 **/
public class ValidPalindrome_125 {
    // 遍历字符串，重新生成只包含字母和数字字符的字串，其中字母统一转换为小写。
    // 然后从字符串首尾开始，对字符一一进行比较判断。
    public static boolean isPalindrome1(String s) {
        if (s == null || "".equals(s)) {
            return true;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                sb.append(Character.toLowerCase(c));
            }
        }

        int i = 0;
        int j = sb.length() - 1;

        while (i < j) {
            if (sb.charAt(i) != sb.charAt(j)) {
                return false;
            }

            i++;
            j--;
        }

        return true;
    }

    // 在原字符串s上使用双指针。
    // 初始时，左右指针分别指向s的两侧，随后不断地将这两个指针相向移动。
    // 每次移动时，如果当前指针指向的字符不是字母或数字，则跳过；否则判断这两个指针指向的字符是否相同，相同则两个指针继续相向移动。
    // 当这两个指针相遇时，就说明s是回文串。

    // 注意Character.isLetterOrDigit和Character.toLowerCase方法的运用

    public static boolean isPalindrome2(String s) {
        if (s == null || "".equals(s)) {
            return true;
        }

        int i = 0;
        int j = s.length() - 1;

        while (i < j) {
            while (i < j && !Character.isLetterOrDigit(s.charAt(i))) {
                i++;
            }

            while (i < j && !Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            }

            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                return false;
            }

            i++;
            j--;
        }

        return true;
    }

    public static void main(String[] args) {
        String s0 = "";
        String s1 = "A man, a plan, a canal: Panama";
        String s2 = "race a car";

        System.out.println(isPalindrome1(s0));
        System.out.println(isPalindrome1(s1));
        System.out.println(isPalindrome1(s2));

        System.out.println(isPalindrome2(s0));
        System.out.println(isPalindrome2(s1));
        System.out.println(isPalindrome2(s2));
    }
}
