package com.simple.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @program:leetcode
 * @author:ibaip
 * @create:2021/5/6 20:29
 * <p>
 * 217. 存在重复元素
 **/
public class ContainsDuplicate_217 {

    // 排序后两两比较
    public static boolean containsDuplicate1(int[] nums) {
        Arrays.sort(nums);

        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == nums[i]) {
                return true;
            }
        }

        return false;
    }

    // 利用Set
    public static boolean containsDuplicate2(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int n : nums) {
            if (!set.add(n)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] ints1 = {1, 2, 3, 1};
        int[] ints2 = {1, 2, 3, 4};
        System.out.println(containsDuplicate1(ints1));
        System.out.println(containsDuplicate1(ints2));
        System.out.println(containsDuplicate2(ints1));
        System.out.println(containsDuplicate2(ints2));
    }
}
