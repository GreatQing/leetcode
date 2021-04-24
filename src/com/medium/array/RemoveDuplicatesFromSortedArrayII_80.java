package com.medium.array;

/**
 * @program:leetcode
 * @author:ibaip
 * @create:2021/4/6 19:46
 *
 * 80. 删除有序数组中的重复项 II
 **/
public class RemoveDuplicatesFromSortedArrayII_80 {

    public static int removeDuplicates(int[] nums) {
        return removeDuplicates(nums, 2);
    }

    // 原题中，每个元素最多出现两次，我们推广到每个元素最多出现k次，使其更加通用：
    // 由于每个元素最多可以出现k次，所以对于前k个元素，直接保留；
    // 从k+1个元素开始，如果当前遍历位置的元素与当前写入位置前k个的元素不相同，则保留。
    public static int removeDuplicates(int[] nums, int k) {
        if (nums == null) {
            return 0;
        }

        // 当前写入位置
        int i = 0;
        // 当前遍历位置
        for (int j = 0; j < nums.length; j++) {
            if (i < k || nums[i - k] != nums[j]) {
                nums[i++] = nums[j];
            }
        }

        return i;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 3, 3, 3, 4, 5, 5, 5, 5, 5, 6, 6, 7, 8, 9, 9, 9};

        int l = removeDuplicates(nums);
        for (int i = 0; i < l; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
