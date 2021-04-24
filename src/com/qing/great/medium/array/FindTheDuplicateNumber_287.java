package com.qing.great.medium.array;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @program:leetcode
 * @author:ibaip
 * @create:2021/4/1 22:53
 *
 * 287. 寻找重复数
 * 给定一个包含n+1个整数的数组nums，其数字都在1到n之间（包括1和n），可知至少存在一个重复的整数。
 * 假设nums只有一个重复的整数，找出这个重复的数。
 **/
public class FindTheDuplicateNumber_287 {

    public static int findDuplicate1(int[] nums) {

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return nums[i];
            }
        }

        return -1;
    }

    public static int findDuplicate2(int[] nums) {
        HashSet set = new HashSet();

        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])) {
                return nums[i];
            }
        }

        return -1;
    }

    public static int findDuplicate3(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int j = i + 1;

            while (j < nums.length) {
                if (nums[i] == nums[j]) {
                    return nums[i];
                } else {
                    j++;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums0 = {1, 3, 4, 2, 2};
        System.out.println(findDuplicate1(nums0));
        System.out.println(findDuplicate2(nums0));
        System.out.println(findDuplicate3(nums0));

        int[] nums1 = {3, 1, 3, 4, 2};
        System.out.println(findDuplicate1(nums1));
        System.out.println(findDuplicate2(nums1));
        System.out.println(findDuplicate3(nums1));

        int[] nums2 = {1, 1};
        System.out.println(findDuplicate1(nums2));
        System.out.println(findDuplicate2(nums2));
        System.out.println(findDuplicate3(nums2));
    }
}
