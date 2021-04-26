package com.medium.bit.manipulation;

import java.util.ArrayList;
import java.util.List;

/**
 * @program:leetcode
 * @author:ibaip
 * @create:2021/4/26 12:48
 * <p>
 * 78. 子集
 **/
public class Subsets_78 {

    // 记原序列中元素的总数为n。
    // 原序列中的每个数字的状态可能有两种，即「在子集中」和「不在子集中」。
    // 用1表示「在子集中」，0表示不在子集中，那么每一个子集可以对应一个长度为n的0/1序列。
    // 可以发现0/1序列对应的二进制数正好从0到2^n-1。
    // 枚举0/1序列，并按照这个0/1序列在原集合当中取数。
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();

        int n = nums.length;
        for (int i = 0; i < 1 << n; i++) {
            List<Integer> list = new ArrayList<>();
            int k = i;

            for (int j = 0; j < n; j++) {
                int cur = 1 & k;
                if (cur == 1) {
                    list.add(nums[j]);
                }
                k = k >> 1;
            }

            lists.add(list);
        }

        return lists;
    }

    public static void main(String[] args) {
        System.out.println(subsets(new int[]{}));
        System.out.println(subsets(new int[]{1, 2, 3}));
    }
}
