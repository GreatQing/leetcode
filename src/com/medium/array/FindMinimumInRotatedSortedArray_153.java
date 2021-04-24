package com.medium.array;

/**
 * @program:leetcode
 * @author:ibaip
 * @create:2021/4/6 20:28
 * <p>
 * 153. 寻找旋转排序数组中的最小值
 **/
public class FindMinimumInRotatedSortedArray_153 {
    // 我们考虑数组中的最后一个元素x：
    // 在最小值右侧的元素（不包括最后一个元素本身），它们的值一定都严格小于x；
    // 而在最小值左侧的元素，它们的值一定都严格大于x。
    // 因此，我们可以根据这一条性质，通过二分查找的方法找出最小值。
    public static int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int mid;

        while (left < right) {
            mid = (right - left) / 2 + left;

            if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return nums[left];
    }

    public static void main(String[] args) {
        int[] nums1 = {4, 5, 6, 7, 0, 1, 2};

        System.out.println(findMin(nums1));

        int[] nums2 = {11, 13, 15, 17};

        System.out.println(findMin(nums2));

        int[] nums3 = {1};

        System.out.println(findMin(nums3));

        int[] nums4 = {3, 1, 2};

        System.out.println(findMin(nums4));

        int[] nums5 = {5, 6, 0, 1, 2, 4};

        System.out.println(findMin(nums5));
    }
}
