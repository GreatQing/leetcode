package com.medium.string;

import java.util.HashMap;

/**
 * @program:leetcode
 * @author:ibaip
 * @create:2021/4/14 20:11
 * <p>
 * 3. 无重复字符的最长子串
 **/
public class LongestSubstringWithoutRepeatingCharacters_3 {

    /*
    思路：
    滑动窗口，保证窗口里面的字符都是唯一的。
    没有重复字符时，调整右边界；
    当窗口内出现重复字符时，调整左边界。
     */
    public static int lengthOfLongestSubstring(String s) {
        // 不含重复字符的最长子串的长度
        int subLength = 0;

        // 其中key保存字符，value保存字符索引+1，表示下一个不重复字符的位置
        HashMap<Character, Integer> map = new HashMap();

        // 遍历字符串，其中[start,end]区间为一个不含重复字符的子串
        for (int start = 0, end = 0; end < s.length(); end++) {
            char c = s.charAt(end);
            // 如果[start,end]区间遇到重复字符，调整start位置
            if (map.containsKey(c)) {
                start = Math.max(start, map.get(c));
            }

            // 每次遍历保存当前字符和下一个位置
            map.put(c, end + 1);
            // 每次遍历计算最长子串的长度
            subLength = Math.max(subLength, end - start + 1);
        }

        return subLength;
    }

    public static void main(String[] args) {
        String s1 = "aaaaaa";
        System.out.println(lengthOfLongestSubstring(s1));

        String s2 = "sasdffsdsesa";
        System.out.println(lengthOfLongestSubstring(s2));
    }
}
