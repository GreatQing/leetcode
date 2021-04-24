package com.medium.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @program:leetcode
 * @author:ibaip
 * @create:2021/4/23 21:46
 * <p>
 * 49. 字母异位词分组
 **/
public class GroupAnagrams_49 {
    // 一.排序
    // 由于互为字母异位词的两个字符串包含的字母相同，因此对两个字符串分别进行排序之后得到的字符串一定是相同的，故可以将排序之后的字符串作为哈希表的键。
    public static List<List<String>> groupAnagrams1(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            // 对字符串进行排序
            char chars[] = str.toCharArray();
            Arrays.sort(chars);

            // 将排序后的字符串作为哈希表的键
            String key = new String(chars);

            // 如果key对应的value已经有list则取出，否则新建list
            List<String> list = map.getOrDefault(key, new ArrayList<String>());

            // 将排序前的字符串存入对应的链表
            list.add(str);
            map.put(key, list);
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};

        System.out.println(groupAnagrams1(strs));
    }
}
