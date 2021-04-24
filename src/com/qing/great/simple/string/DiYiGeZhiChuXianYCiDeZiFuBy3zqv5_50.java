package com.qing.great.simple.string;

import java.util.HashMap;

/**
 * @program:leetcode
 * @author:ibaip
 * @create:2021/4/24 12:44
 * <p>
 * 剑指 Offer 50. 第一个只出现一次的字符
 **/
public class DiYiGeZhiChuXianYCiDeZiFuBy3zqv5_50 {
    public static char firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        // 第一次遍历，把每个字符出现的次数存入哈希表
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // 第二次遍历，从哈希表中获取第一个只出现一次的字符
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return s.charAt(i);
            }
        }

        return ' ';
    }

    public static void main(String[] args) {
        String s1 = "abaccdeff";
        String s2 = "";
        System.out.println(firstUniqChar(s1));
        System.out.println(firstUniqChar(s2));
    }
}
