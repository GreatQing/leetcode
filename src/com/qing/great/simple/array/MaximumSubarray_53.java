package com.qing.great.simple.array;

/**
 * @program:leetcode
 * @author:ibaip
 * @create:2021/4/23 22:46
 * <p>
 * 53. 最大子序和
 **/
public class MaximumSubarray_53 {

    public static int maxSubArray(int[] nums) {
        // 初始化最大子序和为第一个元素
        int ans = nums[0];
        int sum = 0;

        for (int num : nums) {
            if (sum > 0) {
                // 当前遍历数字之前的子序和对结果有增益，则保留
                sum = sum + num;
            } else {
                // 当前遍历数字之前的子序和对结果有增益，则舍弃
                sum = num;
            }

            ans = Math.max(ans, sum);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] nums2 = {1};
        int[] nums3 = {0};
        int[] nums4 = {-1};
        int[] nums5 = {-100000};

        System.out.println(maxSubArray(nums1));
        System.out.println(maxSubArray(nums2));
        System.out.println(maxSubArray(nums3));
        System.out.println(maxSubArray(nums4));
        System.out.println(maxSubArray(nums5));
    }
}
