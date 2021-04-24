package com.qing.great.medium.string;

/**
 * @program:leetcode
 * @author:ibaip
 * @create:2021/4/15 21:17
 * 8. 字符串转换整数 (atoi)
 **/
public class StringToIntegerAtoi_8 {
    /**
     * 有个高赞题解说的非常好，本题模拟的是日常开发中对于原始数据的处理（例如「参数校验」等场景）
     * 其实很多时候，业务需求就是类似这样的问题，工作中如果遇到：
     *
     * 1、有现成的工具和类库需尽量使用，因为它们是性能更优，且经过更严格测试，是相对可靠的；
     * 2、能抽取成工具类、工具方法的尽量抽取，以突出主干逻辑、方便以后代码复用；
     * 3、不得不写得比较繁琐、冗长的时候，需要写清楚注释、体现逻辑层次，以便上线以后排查问题和后续维护。
     */
    public static int myAtoi(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        // 1.去除前导空格
        int i = 0;
        while (i < len && chars[i] == ' ') {
            i++;
        }

        // 2.如果已经遍历完成则返回0，针对只含空字符的情况
        if (i == len) {
            return 0;
        }

        // 3.如果出现符号字符，仅第一个有效。记录符号，默认为正
        int sign = 1;
        if (chars[i] == '-') {
            sign = -1;
            i++;
        } else if (chars[i] == '+') {
            i++;
        }

        // 4.转换后续出现的数字字符
        int x = 0;
        while (i < len) {
            // 遇到非数字字符则结束遍历
            if (chars[i] < '0' || chars[i] > '9') {
                break;
            }

            int y = chars[i] - '0';

            // 如遇正整数溢出，截断为最大正整数
            if (x > Integer.MAX_VALUE / 10 || (x == Integer.MAX_VALUE / 10 && y > Integer.MAX_VALUE % 10)) {
                return Integer.MAX_VALUE;
            }

            // 如遇负整数溢出，截断为最小负整数
            if (x < Integer.MIN_VALUE / 10 || (x == Integer.MIN_VALUE / 10 && y * sign < Integer.MIN_VALUE % 10)) {
                return Integer.MIN_VALUE;
            }

            x = x * 10 + y * sign;
            i++;
        }


        return x;
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("123"));              // 123
        System.out.println(myAtoi(" -123"));            // -123
        System.out.println(myAtoi("4193 with words"));  // 4193
        System.out.println(myAtoi("words and 987"));    // 0
        System.out.println(myAtoi("-91283472332"));     // 被截断为Integer.MIN_VALUE = -2147483648
        System.out.println(myAtoi("3.14159"));          // 3
        System.out.println(myAtoi(""));                 // 0
        System.out.println(myAtoi("   "));              // 0
        System.out.println(myAtoi("-2147483649"));      // -2147483648
        System.out.println(myAtoi(" -1010023630o4"));   // -1010023630
    }
}

